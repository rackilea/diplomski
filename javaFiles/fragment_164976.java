private static final BinaryOperator<Float> ADD_FLOATS = new BinaryOperator<Float>() {
    @Override
    public Float apply(Float t1, Float t2) {
        return t1 + t2;
    }
};

public static <K, V> void merge(Map<K, V> map1, Map<K, V> map2, BinaryOperator<V> op) {
    for (Map.Entry<K, V> e : map2.entrySet()) {
        V val = map1.get(e.getKey());
        if (val == null) {
            map1.put(e.getKey(), e.getValue());
        } else {
            map1.put(e.getKey(), op.apply(val, e.getValue()));
        }
    }
}

public static void main(String[] args) {
    Map<String, Float> map = new HashMap<>();
    map.put("A", 1.2F);
    map.put("B", 3.4F);
    Map<String, Float> map2 = new HashMap<>();
    map2.put("B", 5.6F);
    map2.put("C", 7.8F);
    merge(map, map2, ADD_FLOATS);
    System.out.println(map);   // prints {A=1.2, B=9.0, C=7.8}
}