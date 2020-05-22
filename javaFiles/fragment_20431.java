mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            if (mp.isPlaying())
                mp.stop();
            else
                mp.start();
        }
    });