int bufferSize = Math.max(
    AudioRecord.getMinBufferSize(44100, 
        AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_8BIT),
    ENOUGH_SIZE_FOR_BUFFER);
AudioRecord audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, 
    44100, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_8BIT, bufferSize);