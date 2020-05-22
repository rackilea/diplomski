private static final CONCURRENCY_LEVEL = 64; // must be power of two
List<Object> locks = Lists.newArrayList(); // an array would do as well
for (int i=0; i<CONCURRENCY_LEVEL; ++i) locks.add(new Object());

public void add(Integer key, String value) {
    synchronized (locks.get(hash(key))) {
        cache.get(key).add(value);
    }
}