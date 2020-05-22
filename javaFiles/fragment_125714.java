public final class PropertyComparator extends Comparator<Comparable<?>> {
    private final boolean mUseDscOrder = false;

    public void setUseDscOrder(final boolean useDscOrder) {
            mUseDscOrder = useDscOrder;
    }

    public int compare(final Comparable<?> o1, final Comparable<?> o2) {
            if (!mUseDscOrder) {
                    return o1.compareTo(o2);
            } else {
                    // Reverses the logic, results in DscOrder
                    return o2.compareTo(o1)
            }
    }
}