public interface Map<K, V> {

    default void forEach(BiConsumer<? super K, ? super V> action) { ... }

}                        |
                         |
                         V
@FunctionalInterface
public interface BiConsumer<T, U> {

    void accept(T t, U u); // <-- does throw nothing

}