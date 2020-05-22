public class UsefulThingsService<T> {
    public <V> void makeUsefulThings(List<T> list, Function<T,V> get, BiConsumer<T,V> set) {
        for(T object: list) {
            V v = get.apply(object);
            // there is some code
            set.accept(object, v);
        }
    }
}