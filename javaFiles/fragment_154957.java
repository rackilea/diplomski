public static double[] binCounts(double[] x, double[] binEdges) {
    int binEdgesSize = binEdges.length;
    NavigableMap<Double, Integer> binEdgesMap = new TreeMap<>();
    for (int i = 0; i < binEdgesSize; ++i)
        binEdgesMap.put(binEdges[i], i);
    double [] ret = new double[binEdgesSize - 1];
    for (double d : x) {
        Entry<Double, Integer> e = binEdgesMap.ceilingEntry(d);
        if (e != null)
            ++ret[e.getValue()];
    }
    return ret;
}