public static final void main(final String[] args) {
    final String[] vStrs = new String[] { "A", "Z", "E", "R", "T", "Y" }; // init

    final SortedSet<Map.Entry<String, Double>> vertexCentralities = new TreeSet<Map.Entry<String, Double>>(new Comparator<Map.Entry<String, Double>>() {
        @Override
        public int compare(final Map.Entry<String, Double> e1, final Map.Entry<String, Double> e2) {
            return e2.getValue().compareTo(e1.getValue());
        }
    });
    final SortedMap<String, Double> vMap = new TreeMap<String, Double>();
    double curRank = 0;
    for (final String vStr : vStrs) {
        curRank = new Random().nextDouble() * 100.0; // replacing
                                                        // vertexRank.getVertexScore(vStr);
                                                        // for testing
        vMap.put(vStr, curRank);
    }
    vertexCentralities.addAll(vMap.entrySet());

    for (final Map.Entry<String, Double> entry : vertexCentralities) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }

}