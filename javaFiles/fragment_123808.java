private void setMediaControl(MediaPlayer mp3Player)
{
    System.out.println("Setting Media Viewer");
    gcMediaPlayerControl = new MediaControl(mp3Player);
    border.setBottom(gcMediaPlayerControl);
}