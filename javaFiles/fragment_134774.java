class CopyOnReadList<T> {

    private final List<T> items = new ArrayList<T>();

    public void add(T item) {
        synchronized (items) {
            // Add item while holding the lock.
            items.add(item);
        }
    }

    public List<T> makeSnapshot() {
        List<T> copy = new ArrayList<T>();
        synchronized (items) {
            // Make a copy while holding the lock.
            for (T t : items) copy.add(t);
        }
        return copy;
    }

}

// Usage:
CopyOnReadList<String> stuff = new CopyOnReadList<String>();
stuff.add("hello");
for (String s : stuff.makeSnapshot())
    System.out.println(s);