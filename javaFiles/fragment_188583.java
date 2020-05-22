public static int[] calcHistogram(double[] data, double min, double max, int numBins) {
  final int[] result = new int[numBins];
  final double binSize = (max - min)/numBins;

  for (double d : data) {
    int bin = (int) ((d - min) / binSize);
    if (bin < 0) { /* this data is smaller than min */ }
    else if (bin >= numBins) { /* this data point is bigger than max */ }
    else {
      result[bin] += 1;
    }
  }
  return result;
}