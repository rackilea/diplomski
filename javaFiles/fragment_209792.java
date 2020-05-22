videoView.setMediaController(new MediaController(getActivity()));
    videoView.setVideoPath("android.resource://" + getActivity().getPackageName() + "/" + R.raw.bench);
    videoView.setMediaController(null);
    videoView.start();
    videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mp.setLooping(true);
            mp.setVolume(0, 0);
            mp.start();
        }
    });