public <T> void genericMethod(T t) {
    if (t instanceof Set<?>) {
        Set<?> set = (Set<?>) t;
        if (set.stream().allMatch(String.class:isInstance)) {
            Set<String> strs = (Set<String>) set;
            // Do something with strs here
        }
    }
}