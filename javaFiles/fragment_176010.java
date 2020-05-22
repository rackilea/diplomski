byte[] myBuf = new byte[bufferSize];
audioRecord.startRecording();
while (audioRecord.getRecordingState() == AudioRecord.RECORDSTATE_RECORDING) {
    int l = audioRecord.read(myBuf, 0, myBuf.length);
    if (l > 0) {
        // process data
    }
}