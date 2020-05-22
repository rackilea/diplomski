public class DWrapper implements SortableListItem<Integer> {
    private D item;

    public DWrapper(D item) {
        this.item = item;
    }

    public Integer getValue() {
        return item.getInteger();
    }

    public int compareTo(SortableListItem<Integer> o) {
        return getValue().compareTo(o.getValue());
    }
}