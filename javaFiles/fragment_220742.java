public class LimitedList<T> implements Collection<T> {

    private final LinkedList<T> list;
    private int maximum;

    public LimitedList(int maximum) {
        this.list = new LinkedList<T>();
        this.maximum = maximum;
    }

    @Override
    public boolean add(T t) {
        boolean r = this.list.add(t);
        int n = this.list.size();
        while (n > maximum) {
            this.list.removeFirst();
            n--;
        }
        return r;
    }

    //implement other Collection methods...

}