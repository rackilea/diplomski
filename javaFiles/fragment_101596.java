final int bufferSize = 2200; // in Bytes
soundLine.open(audioFormat, bufferSize);
soundLine.start();
byte counter = 0;
final byte[] buffer = new byte[bufferSize];
byte sign = 1;
while (frame.isVisible()) {
    int threshold = audioFormat.getFrameRate() / sliderValue;
    for (int i = 0; i < bufferSize; i++) {
        if (counter > threshold) {
            sign = (byte) -sign;
            counter = 0;
        }
        buffer[i] = (byte) (sign * 30);
        counter++;
    }
    // the next call is blocking until the entire buffer is 
    // sent to the SourceDataLine
    soundLine.write(buffer, 0, bufferSize);
}