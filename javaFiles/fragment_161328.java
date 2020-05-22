public class UnionListWrapper<A> {
    private final A item;
    private final List<A> list;

    public UnionListWrapper(A value) {
        item = value;
        list = null;
    }

    public UnionListWrapper(List<A> value) {
        item = null;
        list = value;
    }

    public Object getValue() {
        if (item != null) return item;
        else return list;
    }
}