package mcve;
import java.util.*;
import java.util.function.*;

public class ClassToUnaryOpMap {
    private final Map<Class<?>, UnaryOperator<?>> map =
        new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> UnaryOperator<T> put(Class<T> key, UnaryOperator<T> op) {
        return (UnaryOperator<T>) map.put(key, op);
    }

    @SuppressWarnings("unchecked")
    public <T> UnaryOperator<T> get(Class<T> key) {
        return (UnaryOperator<T>) map.get(key);
    }
}