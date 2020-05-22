for (Enum1 e1: Enum1.values()) {
    map.put(e1, new EnumMap<Enum2,V>());
    for (Enum2 e2 : Enum2.values()) {
        map.get(e1).put(e2, getSomeValue(e1, e2));
    }
}