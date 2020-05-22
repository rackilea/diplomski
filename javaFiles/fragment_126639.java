public boolean parseServerInfo(String data) {
    if (numCameras == 0) {
        Toast.makeText(mContext, "No stream detected!", Toast.LENGTH_LONG).show();

        // Finish is called here... AND FALSE IS RETURNED
        VideoPlayer videoplayer = (VideoPlayer) mContext;
        videoplayer.finish();
        return false;
    }
    return true;
}