public <T> void genericMethod(T t) {
    if (t instanceof Set<?>) {
        Set<?> set = (Set<?>) t;
        if (Iterables.all(set, Predicates.instanceOf(String.class))) {
            Set<String> strs = (Set<String>) set;
            // Do something with strs here
        }
    }
}