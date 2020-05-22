public void onPrepared(MediaPlayer mediaPlayer) {
    Log.d("mylog", "onPrepared");
    mMediaController.setMediaPlayer(this);
    mMediaController.setAnchorView(findViewById(R.id.audioView));

    mHandler.post(new Runnable() {
      public void run() {

          mMediaController.setEnabled(true);
          mMediaController.show();
      }
    });
  }