Games.Snapshots.load(mGoogleApiClient, false).setResultCallback(
      new ResultCallback<Snapshots.LoadSnapshotsResult>() {
          @Override
          public void onResult(Snapshots.LoadSnapshotsResult loadSnapshotsResult) {
                     mSavedGamesNames = new ArrayList<String>();
                     for (SnapshotMetadata m :loadSnapshotsResult.getSnapshots()) {
                         mSavedGamesNames.add(m.getUniqueName());
                     }
         }
});