public interface Keyed<K> {
    /**
     * returns the key of the enum
     */
    K getKey();
}

public class KeyEnumMapping<K, E extends Enum<?> & Keyed<K>> {
    private Map<K, E> map = new HashMap<>();

    public KeyEnumMapping(Class<E> clazz) {
        E[] enumConstants = clazz.getEnumConstants();
        for (E e : enumConstants) {
            map.put(e.getKey(), e);
        }
    }

    public E get(K key) {
        return map.get(key);
    }
}

public enum Example implements Keyed<Integer> {
    A(1),
    B(3),
    C(7);

    private static final KeyEnumMapping<Integer, Example> MAPPING = new KeyEnumMapping<>(Example.class);
    private Integer value;

    Example(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getKey() {
        return value;
    }

    public static Example getByValue(Integer value) {
        return MAPPING.get(value);
    }

    public static void main(String[] args) {
        System.out.println(Example.getByValue(3));
    }
}