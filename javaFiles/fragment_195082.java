static <T> boolean deepContains(Map<?, ?> map, T item) {
    for (Entry<?, ?> entry: map.entrySet()) {
        final Object value = entry.getValue();
        boolean returned = false;
        if (value instanceof Map<?, ?>) {
            returned = deepContains((Map<?, ?>) value, item);
        } else {
            returned = item.getClass().cast(value).equals(item);
        }
        if (returned) {return true;}
    }
    return false;
}