public class FasterPool<T> implements Pool<T> {
    private List<T> list = new ArrayList<>();
    private int size = 0;
    Random rand = new Random();

    public void put(T t) {
        if (size == list.size()) {
            list.append(t);
        } else {
            list.set(size, t);
        size++;
    }

    public T randomRemove() {
        int pos = rand.nextInt(size);
        T result = list.get(pos);
        if (pos < size - 1) {
            list.set(pos, list.get(size - 1));
        }
        list.set(size - 1, null);  // avoid memory leak ...
        size--;
        return result;
    }
}