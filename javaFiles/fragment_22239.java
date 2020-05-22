mediaPlayer = MediaPlayer.create(this,sound);
mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.reset();
                mp.release();
                mediaplayer = null;
            }
        });
mediaPlayer.start();