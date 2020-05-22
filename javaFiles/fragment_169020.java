recorder = new AudioRecord(MediaRecorder.AudioSource.MIC, SampleRate, Channels, Encoding, BufferElements2Rec*BytesPerElement);

if (recorder.getState() == AudioRecord.STATE_INITIALIZED) {
    recorder.startRecording();
    isRecording = true;
    //rest of the code
}
else {
    //not initialized properly
}