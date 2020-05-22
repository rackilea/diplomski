mp.prepare();
         mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
           mp.setVolume(1f, 1f);
           mp.setLooping(false);
           mp.start(); 
        }
    });