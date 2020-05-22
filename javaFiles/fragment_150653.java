float gain = getGain(); // taken from the UI control, perhaps in range from 0.0 to 2.0
int numRead = read(audioData, 0, SIZE);
if (numRead > 0) {
    for (int i = 0; i < numRead; ++i) {
        audioData[i] = (short)Math.min((int)(audioData[i] * gain), (int)Short.MAX_VALUE);
    }
}