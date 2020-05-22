if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        AudioAttributes attributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_MEDIA)
                .setFlags(AudioAttributes.FLAG_AUDIBILITY_ENFORCED)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();

        mSoundPool = new SoundPool.Builder().setAudioAttributes(attributes).setMaxStreams(6).build();
    } else {
        mSoundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
    }