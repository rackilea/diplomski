public void onCompletion(MediaPlayer arg0) {
        arg0.release();
        currentTrack++;
        if (currentTrack < tracks.length) {

            arg0 = MediaPlayer.create(getApplicationContext(), tracks[currentTrack]);
            arg0.setOnCompletionListener(this);
            arg0.start();
        }
    }