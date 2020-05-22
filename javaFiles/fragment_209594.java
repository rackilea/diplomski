public static void playAudioFromRaw(short[] data){
        int bufsize = AudioTrack.getMinBufferSize(
                8000,
                AudioFormat.CHANNEL_IN_STEREO,
                AudioFormat.ENCODING_PCM_16BIT
        );
        AudioTrack trackplayer = new AudioTrack(
                AudioManager.STREAM_MUSIC, 8000,
                AudioFormat.CHANNEL_IN_STEREO,
                AudioFormat.ENCODING_PCM_16BIT,
                bufsize,
                AudioTrack.MODE_STREAM
        );
        trackplayer.play();
        trackplayer.write(data, 0, data.length);
        trackplayer.stop();
        trackplayer.release();
    }