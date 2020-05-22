AudioRecord recorder; // our recorder, must be initialized first
short[] buffer; // buffer where we will put captured samples
DataOutputStream output; // output stream to target file
boolean isRecording; // indicates if sound is currently being captured
ProgressBar pb; // our progress bar 
while (isRecording) {
    double sum = 0;
    int readSize = recorder.read(buffer, 0, buffer.length);
    for (int i = 0; i < readSize; i++) {
        output.writeShort(buffer [i]);
        sum += buffer [i] * buffer [i];
    }
    if (readSize > 0) {
        final double amplitude = sum / readSize;
        pb.setProgress((int) Math.sqrt(amplitude));
    }
}