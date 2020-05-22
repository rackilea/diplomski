public void audioRecordLoop() throws Exception {
        Log.e(TAG,"start audioRecordLoop");
        int channelConfig = mChannels == 2?
                AudioFormat.CHANNEL_IN_STEREO:
                AudioFormat.CHANNEL_IN_MONO;
        int bufferSize = AudioRecord.getMinBufferSize(
                mSampleRateHz, channelConfig, mAudioEncoding);
        mAudioRecord = new AudioRecord(
                mAudioSource, mSampleRateHz, channelConfig, mAudioEncoding, bufferSize);// The RAW PCM sample recording

        if (mAudioRecord.getState() != AudioRecord.STATE_INITIALIZED) {
            Log.e(TAG,"AudioRecord init failed");
            return;
        }
        final short[] buffer = new short[mBlockSize];
        mAudioRecord.startRecording();
        int len = 0;
        while (mbExit == false) {
            len = mAudioRecord.read(buffer, 0, mBlockSize);
            if (len < 0) {
                Log.e(TAG,"read error " + len);
                return;
            }
        }
        mAudioRecord.stop();
        mAudioRecord.release();
    }