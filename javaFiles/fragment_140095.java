public void play(MenuItem menuItem) {

        if (!isPlaying && !isPaused) {

        try {
            if (mp == null) {
                // mp.release();
                // mp.reset();
                mp = new MediaPlayer();
                AssetFileDescriptor afd = getAssets()
                        .openFd("caketown.mp3");
                mp.setDataSource(afd.getFileDescriptor(),
                        afd.getStartOffset(), afd.getLength());
                mp.prepare();

                mp.setOnCompletionListener(new OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer arg0) {
                        // TODO Auto-generated method stub
                        isPlaying = false;// when the media file playing is completed
                        isPaused = false;
                        // Toast.makeText(getApplicationContext(), "play completed",
                        // Toast.LENGTH_SHORT).show(); // isPlaying=false; is must
                    }
                });
            }
            mp.start();// play sound
        } catch (Exception e) {
            e.printStackTrace();
        }
        isPlaying = true;

        } else if (isPlaying) {
            Toast.makeText(getApplicationContext(), "play paused",
                    Toast.LENGTH_SHORT).show();
            mp.pause();
            isPlaying = false;
            isPaused = true;
            length = mp.getCurrentPosition();
            // and for resuming the player from the position where it stopped
            // lately is done by:

        } else if (isPaused) {
            mp.seekTo(length);
            mp.start();
            isPlaying = true;
            isPaused = false;
        }
    }