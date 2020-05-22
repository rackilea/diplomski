public <T> void genericMethod(T t) {
    Set<String> strs = new HashSet<String>();
    Set<?> tAsSet;
    if (t instanceof Set<?>) {
        tAsSet = (Set<?>) t;
        for (Object obj : tAsSet) {
            if (obj instanceof String) {
                strs.add((String) obj);
            }
        }
        // Do something with strs here
    } else {
        // Throw an exception or log a warning or something.
    }
}