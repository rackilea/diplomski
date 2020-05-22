private final Map<Class<?>, List<?>> map;
public <T> void add(T obj) {
    Class c = obj.getClass(); // yeah, raw.
    map.computeIfAbsent(c, x -> new ArrayList()).add(obj); // raw again.
}

public <T> T getFirst(Class<T> type) {
    List list = map.getOrDefault(type, List.of());
    return (T) (list.isEmpty() ? null : list.get(0));
}