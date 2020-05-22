float[] interleaveData(float[][] data) {
  int numChannels = data.length;
  int numFrames   = data[0].length;

  float[] result = new float[numFrames*numChannels];
  for (int i = 0; i < numFrames; i++) {
    for (int ch = 0; ch < numChannels; ch++) {
      result[numChannels * i + ch] = data[ch][i];
    }
  }
  return result;
}