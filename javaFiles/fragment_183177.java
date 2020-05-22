public List<Object> toArray(Map<String, Object> properties) {
    List<Object> result = new ArrayList<>();

    for (Object obj : properties.values()) {
        Object elem = null;
        if (obj != null) {
            Class<?> clz = obj.getClass();
            if (Map.class.isAssignableFrom(clz)) {
                elem = toArray((Map<String, Object>) obj); // recursion!
            } else {
                elem = obj;
            }
        }
        result.add(elem); // this adds null values
                          // move 1 line up if you don't
                          // want to serialize nulls
    }
    return result;
}