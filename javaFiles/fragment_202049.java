public class Haha<E extends Comparable<? super E>> {
    public static <T extends Comparable<? super T>> void sort (T[] a) {
        // unusual, but can be done
        final Haha<T> haha = new Haha<T>(a);
    }

    private E[] array;

    public Haha() {
        this(new Comparable[10];
    }

    public Haha(final E[] array) {
        super();
        this.array = array;
    }
}