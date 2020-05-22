package mcve;
import java.util.*;
import java.util.function.*;

class ClassToConsumerMap {
    private final Map<Class<?>, Consumer<?>> map =
        new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> Consumer<? super T> put(Class<T> key, Consumer<? super T> c) {
        return (Consumer<? super T>) map.put(key, c);
    }

    @SuppressWarnings("unchecked")
    public <T> Consumer<? super T> get(Class<T> key) {
        return (Consumer<? super T>) map.get(key);
    }
}