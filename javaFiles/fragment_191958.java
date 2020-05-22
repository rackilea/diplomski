class ImposedOrder<T> implements Comparator<T> {

    private final List<T> list;
    private final int startIndex;

    ImposedOrder(List<T> list, T startElement) {
        this.list = new ArrayList<>(list);
        this.startIndex = list.indexOf(startElement);
        if (startIndex < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compare(T t1, T t2) {
        int t1Index = list.indexOf(t1);
        int t2Index = list.indexOf(t2);
        return Integer.compare(adjust(t1Index), adjust(t2Index));
    }

    private int adjust(int rawIndex) {
        if (rawIndex >= startIndex) {
            return rawIndex;
        }
        return rawIndex + list.size();
    }
}