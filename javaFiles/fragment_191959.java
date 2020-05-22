class ImposedOrder<T> implements Comparator<T> {

    private final Map<T, Integer> map;
    private final int startIndex;

    ImposedOrder(List<T> list, T startElement) {
        this.startIndex = list.indexOf(startElement);
        if (startIndex < 0) {
            throw new IllegalArgumentException();
        }
        this.map = IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.toMap(
                        list::get,
                        i -> adjust(startIndex, list.size(), i)
                ));
    }

    @Override
    public int compare(T t1, T t2) {
        Integer t1Index = map.get(t1);
        Integer t2Index = map.get(t2);
        return t1Index.compareTo(t2Index);
    }

    private static int adjust(int startIndex, int size, int rawIndex) {
        if (rawIndex >= startIndex) {
            return rawIndex;
        }
        return rawIndex + size;
    }
}