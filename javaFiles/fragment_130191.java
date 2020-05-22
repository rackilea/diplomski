public byte[] doubleArrayToByteArray(double[] input, int bytesPerSample, double scaleFactor, boolean fullNormalize, boolean bigEndian) {
    byte[] result = new byte[input.length * bytesPerSample];
    performNormalization(input, scaleFactor, fullNormalize);
    for (int i = 0; i < input.length; i++) {
        long sourceVal = (long)(input[i] * scaleFactor);
        sourceVal = sourceVal >> 8 * (8 - bytesPerSample);
        for (int j = 0; j < bytesPerSample; j++) {
            int index = i * bytesPerSample;
            if (bigEndian) {
                index += (bytesPerSample - j);
            }
            else {
                index += j;
            }
            result[index] = (byte) sourceVal;
            sourceVal = sourceVal >> 8;
        }
    }
    return result;
}

public void performNormalization(double[] input, double scaleFactor, boolean fullNormalize) {
    double maxVal = 0.0;
    for (int i = 0; i < input.length; i++) {
        double val = Math.abs(input[i]) * scaleFactor;
        if (val > maxVal) {
            maxVal = val;
        }
    }
    if (fullNormalize || maxVal > Long.MAX_VALUE) {
        double normalizeFactor = (double)(Long.MAX_VALUE) / maxVal;
        for (int i = 0; i < input.length; i++) {
            input[i] *= normalizeFactor;
        }
    }
}