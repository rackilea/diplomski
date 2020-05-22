@SafeVarargs
@SuppressWarnings("unchecked")
private static <E extends Comparable<E>> List<E> getCommonValues(Iterable<? extends E> ... lists) {
    // For each list: Get iterator and first value
    Iterator<? extends E>[] iter  = new Iterator[lists.length];
    E[] value = (E[])new Comparable[lists.length];
    for (int i = 0; i < lists.length; i++) {
        iter[i] = lists[i].iterator();
        value[i] = (iter[i].hasNext() ? iter[i].next() : null);
    }

    List<E> commonValues = new ArrayList<>();
    while (true) {

        // Find value count, lowest value, and count of lowest value
        int valueCount = 0, lowestCount = 0;
        E lowestValue = null;
        for (int i = 0; i < lists.length; i++)
            if (value[i] != null) {
                valueCount++;
                int cmp = (lowestValue == null ? -1 : value[i].compareTo(lowestValue));
                if (cmp < 0) {
                    lowestCount = 1;
                    lowestValue = value[i];
                } else if (cmp == 0) {
                    lowestCount++;
                }
            }

        // Exit loop if no more values
        if (valueCount == 0)
            break;

        // Save common value if all values were lowest value
        if (lowestCount == lists.length)
            commonValues.add(lowestValue);

        // For each list: Get next value if value was lowest value
        for (int i = 0; i < lists.length; i++)
            if (value[i] != null && value[i].compareTo(lowestValue) == 0)
                value[i] = (iter[i].hasNext() ? iter[i].next() : null);
    }

    return commonValues;
}