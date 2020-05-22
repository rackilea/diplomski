import java.util.Iterator;
import java.util.LinkedHashSet;

public class MyLinkedHashSet<T> extends LinkedHashSet<T> {
    private long maxSize;

    public MyLinkedHashSet(long maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean add(T item) {
        if(size() == maxSize) {
            removeFirst();
        }
        return super.add(item);
    }

    private void removeFirst() {
        if(size() > 0) {
            Iterator<T> iterator = iterator();
            T item = iterator.next();
            remove(item);
        }
    }

    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new MyLinkedHashSet<>(3);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println(set);    // [2, 3, 4]
        set.clear();
        System.out.println(set);    // []
        set.addAll(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(set);    // [3, 4, 5]
    }
}