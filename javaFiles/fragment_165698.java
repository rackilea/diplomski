public final class MyReference<T> extends ReentrantLock implements Comparable<MyReference<T>> {
    public MyReference() {
        id = counter.incrementAndGet();
    }

    public void swap(MyReference<T> other) {
        if (id < other.id) {
            lock();
            other.lock();
        } else {
            other.lock();
            lock();
        }
        final T tmp = value;
        value = other.value;
        other.value = tmp;
        unlock();
        other.unlock();
    }

    public static <T> List<T> consistentGet(List<MyReference<T>> references) {
        final ArrayList<MyReference<T>> sortedReferences = Lists.newArrayList(references);
        Collections.sort(sortedReferences);
        for (val r : sortedReferences) r.lock();
        final List<T> result = Lists.newArrayListWithExpectedSize(sortedReferences.size());
        for (val r : references) result.add(r.value);
        for (val r : sortedReferences) r.unlock();
        return result;
    }

    @Override
    public int compareTo(MyReference<T> o) {
        return id < o.id ? -1 : id > o.id ? 1 : 0;
    }

    private final static AtomicInteger counter = new AtomicInteger();

    private T value;
    private final int id;
}