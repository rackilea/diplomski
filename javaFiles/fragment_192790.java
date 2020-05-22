private String[] videos = {"video1", "video2"};
private int currentVideoIndex = 0 ;

private void playNextVideo() {
    Media media = new Media(uri(videos[currentVideoIndex]));
    currentVideoIndex++ ;
    MediaPlayer player = new MediaPlayer(media);
    player.setOnEndOfMedia(() -> {
        if (currentVideoIndex < videos.length) {
            playNextVideo();
        }
    });
    player.setAutoPlay(true);
    view.setMediaPlayer(player);
}