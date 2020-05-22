videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
        videoview.stopPlayback();
        videoview.setVideoURI(uri);
        videoview.start();
    }
});
videoview.setVideoURI(uri);
videoview.start();