public class RemovalCountingList<E> implements List<E> {
    @Delegate(excludes = ExcludedListMethods.class)
    private final List<E> delegate;
    private final AtomicInteger removalCount = new AtomicInteger();
    public RemovalCountingList(List<E> delegate) {
        this.delegate = delegate;
    }
    @Override
    public E remove(int index) {
        System.out.println("Removal count: " + removalCount.incrementAndGet());
        return delegate.remove(index);
    }
    @Override
    public boolean remove(Object o) {
        boolean isRemoved = delegate.remove(o);
        if (isRemoved) {
            System.out.println("Removal count: " + removalCount.incrementAndGet());
        }
        return isRemoved;
    }
    /**
     * Excluded methods that Lombok will not implement, we will implement/override these methods.
     */
        private abstract class ExcludedListMethods {
            public abstract E remove(int index);
            public abstract boolean remove(Object o);
        }
    }

public class ClientMain {
    public static void main(String[] args) {
        RemovalCountingList<String> cities = new RemovalCountingList<>(new ArrayList<>());
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Tokyo");
        String removedCity = cities.remove(0);
        System.out.println("Removed city: " + removedCity);
        boolean isRemoved = cities.remove("Istanbul");
        System.out.println("Is removed?: " + isRemoved);
    }
}