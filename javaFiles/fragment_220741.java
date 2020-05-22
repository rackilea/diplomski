public class LimitedList<T> extends LinkedList<T> {

    private int maximum;

    public LimitedList(int maximum) {
        this.maximum = maximum;
    }

    @Override
    public boolean add(T t) {
        boolean r = super.add(t);
        int n = this.size();
        while (n > maximum) {
            this.removeFirst();
            n--;
        }
        return r;
    }

}