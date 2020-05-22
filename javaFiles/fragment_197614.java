private OnClickListener onButtonClick = new OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                if (player.isPlaying()) {
                    handler.removeCallbacks(updatePositionRunnable);
                    player.pause();
                    playButton.setImageResource(android.R.drawable.ic_media_play);
                else {
                    if (isStarted) {
                        player.start();
                        playButton.setImageResource(android.R.drawable.ic_media_pause);
                        updatePosition();
                    } else {
                        startPlay(currentFile);
                    }
                }
                break;
            case R.id.next:
                int seekto = player.getCurrentPosition() + STEP_VALUE;

                if (seekto > player.getDuration()) {
                        seekto = player.getDuration();
                }

                player.pause();
                player.seekTo(seekto);
                player.start();

                break;
            case R.id.prev:
                int seekto = player.getCurrentPosition() - STEP_VALUE;
                if (seekto < 0) {
                    seekto = 0;
                }

                player.pause();
                player.seekTo(seekto);
                player.start();

                break;
        }
    }
};

private MediaPlayer.OnCompletionListener onCompletion = new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
        stopPlay();
    }
};

private MediaPlayer.OnErrorListener onError = new MediaPlayer.OnErrorListener() {
    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }
};

private SeekBar.OnSeekBarChangeListener seekBarChanged = new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        isMoveingSeekBar = false;
    }

    @Override
    public void OnStartTrackingTouch(SeekBar seekBar) {
        isMoveingSeekBar = true;
    }

    @Override
    public void OnProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (isMoveingSeekBar) {
            player.seekTo(progress);
            Log.i("OnSeekBarChangedListener", "OnProgressChanged");
        }
    }
};