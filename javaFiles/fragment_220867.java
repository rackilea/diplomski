mediaplayer = new EmbeddedMediaPlayerComponent();

        embededMediaPlayer = mediaplayer.getMediaPlayer();
        embededMediaPlayer.setRepeat(true);
        videoSurface = mediaplayer.getVideoSurface();

        embededMediaPlayer.addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            /**
             *
             * @param mediaPlayer play video
             * @param newTime get every millisecond changed in the mediaplayer
             * when is in playing mode
             */
            @Override
            public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
                super.timeChanged(mediaPlayer, newTime);
                // here put you code to set new slider progress value 
                }
            });