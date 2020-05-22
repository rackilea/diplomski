class SortedEnumMap<K extends Enum<K>, V> 
    extends EnumMap<K, V> 
    implements SortedMap<K, V> {

    private Class<K> enumClass;
    private K[] values;

    public SortedEnumMap(Class<K> keyType) {
        super(keyType);
        this.values = keyType.getEnumConstants();
        this.enumClass = keyType;

        if (this.values.length == 0) {
            throw new IllegalArgumentException("Empty values");
        }
    }

    @Override
    public Comparator<? super K> comparator() {
        return Comparator.comparingInt(K::ordinal);
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        List<K> keys = Arrays.stream(this.values)
                .dropWhile(k -> k.ordinal() < fromKey.ordinal())
                .takeWhile(k -> k.ordinal() < toKey.ordinal())
                .collect(Collectors.toList());

        return this.forKeys(keys);
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        List<K> keys = new ArrayList<>();

        for (K k : this.values) {
            if (k.ordinal() < toKey.ordinal()) {
                keys.add(k);
            } else {
                break;
            }
        }

        return this.forKeys(keys);
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        List<K> keys = new ArrayList<>();

        for (K k : this.values) {
            if (k.ordinal() >= fromKey.ordinal()) {
                keys.add(k);
            }
        }

        return this.forKeys(keys);
    }

    //Returned map is NOT a "view" or the current one
    private SortedEnumMap<K, V> forKeys(List<K> keys) {
        SortedEnumMap<K, V> n = new SortedEnumMap<>(this.enumClass);
        keys.forEach(key -> n.put(key, super.get(key)));

        return n;
    }

    @Override
    public K firstKey() {
        return this.values[0];
    }

    @Override
    public K lastKey() {
        return this.values[this.values.length - 1];
    }
}