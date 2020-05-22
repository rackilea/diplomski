public class SomeClass {
    private static final int MAX_POOL_SIZE = . . .;
    private static final ArrayList<SomeClass> pool = new ArrayList<SomeClass>();

    public static SomeClass getInstance() {
        int poolSize = pool.size();
        if (poolSize > 0) {
            return pool.remove(poolSize-1);
        }
        return new SomeClass();
    }

    public void recycle() {
        // reset any fields
        if (pool.size() < MAX_POOL_SIZE) {
            pool.add(this);
        }
    }
    . . .
}