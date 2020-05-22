new MediaPlayer.create(getApplicationContext(), R.raw.test)
            .start()
            .setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                 public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });