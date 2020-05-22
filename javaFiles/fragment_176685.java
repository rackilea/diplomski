double currentPos = 0.0;
for (int i = 0; i < numSamples; ++i) {
    numerator = (double) i / (double) numSamples;
    currentFreq = startFreq + (numerator * (endFreq - startFreq))/2;
    if ((i % 1000) == 0) {
        Log.e("Current Freq:", String.format("Freq is:  %f at loop %d of %d", currentFreq, i, numSamples));
    }
    currentPos += 2 * Math.PI * (currentFreq / sampleRate);
    sample[i] = Math.sin(currentPos);
}