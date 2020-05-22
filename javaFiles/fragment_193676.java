int sampleIndex = 0;

for (int t = 0; t < eightBitByteArray.length;) {
    for (int channel = 0; channel < numChannels; channel++) {
        int low = (int) eightBitByteArray[t];
        t++;
        int high = (int) eightBitByteArray[t];
        t++;
        int sample = getSixteenBitSample(high, low);
        toReturn[channel][sampleIndex] = sample;
    }
    sampleIndex++;
}