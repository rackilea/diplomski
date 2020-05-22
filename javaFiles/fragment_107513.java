public interface Selector<T> {
    public boolean select(T t); }

public <T> Set<T> grep(Collection<T> coll, Selector<T> sel) {
    Set<T> result = new Set<T>;
    for (T item : coll)
        if (sel.select(T)) 
            result.add(T);
    return result;
}