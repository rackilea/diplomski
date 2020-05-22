public class ListSorter<V> {

    private final List<V> values;
    private String sortingAttribute;

    public ListSorter(List<V> values) {
        this.values = values;
    }

    public void sort(AttributeComparator<V> comparator) {
        Collections.sort(values, comparator);
        sortingAttribute = comparator.getSortingAttribute();
    }

    public String getSortingAttribute() {
        return sortingAttribute;
    }
}