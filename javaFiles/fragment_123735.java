private static <E extends Enum<E>> Map<String,E> makeValueMap(E[] values) {
    final Map<String,E> tmpMap = new HashMap<String,E>();
    for(final E en : values) {
        tmpMap.put(en.name(), en);
    }
    return tmpMap;
}