public class KeyEnumMapping<K, E extends Enum<?>> {
    private Map<K, E> map = new HashMap<>();

    public KeyEnumMapping(Class<E> clazz, Function<E, K> keyExtractor) {
        E[] enumConstants = clazz.getEnumConstants();
        for (E e : enumConstants) {
            map.put(keyExtractor.apply(e), e);
        }
    }

    public E get(K key) {
        return map.get(key);
    }
}

public enum Example {
    A(1),
    B(3),
    C(7);

    private static final KeyEnumMapping<Integer, Example> MAPPING =
        new KeyEnumMapping<>(Example.class, Example::getValue);
    private Integer value;

    Example(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static Example getByValue(Integer value) {
        return MAPPING.get(value);
    }

    public static void main(String[] args) {
        System.out.println(Example.getByValue(3));
    }
}