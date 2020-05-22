@Before
  public void setup() throws Exception {
    media = new Media(getClass().getResource("small.mp4").toString());
    mediaPlayer1 = new MediaPlayer(media);
    mediaPlayer1.setOnError(() -> fail("media error" + mediaPlayer1.getError().toString()));
    int retries = 0;
    while (mediaPlayer1.getStatus() != MediaPlayer.Status.READY) {
      System.out
          .println("media player not yet READY - current status: " + mediaPlayer1.getStatus());
      sleep(100);
      retries++;
      if (retries > 10) {
        fail("waited too long for media player to get READY");
      }   
    }   
    mediaView1 = find("#mediaView1");
    mediaView1.setMediaPlayer(mediaPlayer1);
    mediaPlayer1.play();
    retries = 0;
    while (mediaPlayer1.getStatus() != MediaPlayer.Status.PLAYING) {
      System.out
          .println("media player not yet PLAYING - current status: " + mediaPlayer1.getStatus());
      sleep(100);
      retries++;
      if (retries > 10) {
        fail("waited too long for media player to get PLAYING");
      }   
    }   
  }