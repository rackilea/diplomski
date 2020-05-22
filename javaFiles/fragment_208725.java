Map<Double, Integer> coinsMap =
    new TreeMap<Double, Integer>(new Comparator<Double>() {
        public int compare(Double coin1, Double coin2) {
            return (coin2.compareTo(coin1));
        }
    });