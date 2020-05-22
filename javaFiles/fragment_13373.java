Comparator<Integer> comparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer x, Integer y) {
        return x - y;
    }
};

BiFunction<Integer, Integer, Integer> biFun = new BiFunction<Integer, Integer, Integer>() {
    @Override
    public Integer apply(final Integer x, final Integer y) {
        return x - y;
    }
};