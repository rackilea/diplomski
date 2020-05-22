public class ObjectPool<T> {
    private List<T> objects;
    private Class<T> clazz;
    private int size;

    public ObjectPool(Class<T> clazz, int size) throws IllegalStateException {
        this.clazz = clazz;
        this.size = size;
        this.objects = new ArrayList<T>();
        for (int i = 0;i < size;i++) {
            objects.add(newInstance());
        }
    }

    // You can override this method with anonymous class
    protected T newInstance() {
        try {
            return clazz.newInstance()
        } catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
    }

    public synchronized T getInstance() {
        if (objects.isEmpty()) {
            return null;
        }
        return objects.remove(objects.size() - 1);
    }

    public synchronized void returnInstance(T instance) {
        if (objects.size() < size) {
            objects.add(instance);
        }
    }
}