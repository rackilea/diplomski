private <T extends Number> T getValue (Map<Integer, T> map, Integer key, T dflt) {
    return (T) ((map.containsKey(key)) ? map.get(key) : dflt);
}

public static void main(String[] args) {
    Integer a = getValue(aMap, 15, 0); //okay in any case
    Short b = getValue(bMap, 15, (short)0); //15 key does not exist
}