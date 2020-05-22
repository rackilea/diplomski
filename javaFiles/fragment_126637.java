public void parseServerInfo(String data) {
    if (numCameras == 0) {
        Toast.makeText(mContext, "No stream detected!", Toast.LENGTH_LONG).show();

        // Finish is called here
        VideoPlayer videoplayer = (VideoPlayer)getContext();
        videoplayer.finish();
        return;
    }
}