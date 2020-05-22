Resources res = getResources();
    AssetFileDescriptor afd = res.openRawResourceFd(R.raw.tts_a);

    mp = new MediaPlayer();
    //mp.reset();
    mp.setAudioStreamType(AudioManager.STREAM_VOICE_CALL);
    mp.setLooping(false);
    try {
        mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        mp.prepare();
    } catch (IOException e) {
        e.printStackTrace();
    }

    mp.start();