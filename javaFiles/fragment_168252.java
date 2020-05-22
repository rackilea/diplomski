playVideo(String uri) {

    videoView.setVideoURI(uri);
    videoView.requestFocus();
    videoView.start();
}