class DoubleComparator implements Comparator<Map.Entry<Integer, Double>> {

    @Override
    public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
        return Double.compare(o1.getValue(), o2.getValue());
    }
}