stopPlaying();
      mp = MediaPlayer.create(PlayaudioActivity.this, R.raw.ok); //R.raw.ok is new audio file
      mp.start();

     private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
       }
    }