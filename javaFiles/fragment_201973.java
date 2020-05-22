public class ListPool<T> implements Pool<T> {
    private List<T> list = ArrayList<>();

    public void put(T t) {
        list.append(t);
    }

    public T randomRemove() {
        return list.remove(rand.nextInt(list.size()));
    }
}