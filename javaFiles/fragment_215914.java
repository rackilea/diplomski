String serializedSavedGameData;
public void downloadSavedGameData(final String name) {
    if(snapshotsClient != null) {
        snapshotsClient.open(name, true, SnapshotsClient.RESOLUTION_POLICY_MOST_RECENTLY_MODIFIED).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "Error while opening snapshot: ", e);
            }
        }).continueWith(new Continuation<SnapshotsClient.DataOrConflict<Snapshot>, byte[]>() {
            @Override
            public byte[] then(@NonNull Task<SnapshotsClient.DataOrConflict<Snapshot>> task) throws Exception {
                Snapshot snapshot = task.getResult().getData();
                // Opening the snapshot was a success and any conflicts have been resolved.
                try {
                    // Extract the raw data from the snapshot.
                    return snapshot.getSnapshotContents().readFully();
                } catch (IOException e) {
                    Log.e(TAG, "Error while reading snapshot: ", e);
                } catch (NullPointerException e) {
                    Log.e(TAG, "Error while reading snapshot: ", e);
                }
                return null;
            }
        }).addOnCompleteListener(new OnCompleteListener<byte[]>() {
            @Override
            public void onComplete(@NonNull Task<byte[]> task) {
                if(task.isSuccessful()) {
                    byte[] data = task.getResult();
                    try {
                        serializedSavedGameData = new String(data, "UTF-16BE");
                    } catch (UnsupportedEncodingException e) {
                        Log.d(TAG, "Failed to deserialize save game data: " + e.getMessage());
                    }
                } else {
                    Exception ex = task.getException();
                    Log.d(TAG, "Failed to load saved game data: " + (ex != null ? ex.getMessage() : "UNKNOWN"));
                }
            }
        });
    }
}