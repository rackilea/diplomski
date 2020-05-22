StorageReference videoRef = storageRef.child("videos/myvideo.mp4");

final long ONE_MEGABYTE = 1024 * 1024;
videoRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
    @Override
    public void onSuccess(byte[] bytes) {
        // Transform bytes to a video, play
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception exception) {
        // Handle any errors
    }
});