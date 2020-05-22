Integer blown() {
    List<Integer> intList = new ArrayList<Integer>();
    Iterable<?> iterable = intList;

    @SuppressWarnings("unchecked") // This cast should be safe, shouldn't it?
    Iterable<Object> objectIterable = (Iterable<Object>) iterable;
    safeMethod(objectIterable);

    return intList.get(0);
}

// This method is definitely fine, no unchecked cast.
private void safeMethod(Iterable<Object> objectIterable) {
    if (objectIterable instanceof List) {
        List<Object> list = (List<Object>) objectIterable;
        list.add("blown!");
    }
}