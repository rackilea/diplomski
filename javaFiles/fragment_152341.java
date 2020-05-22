public static <T> T[] genericMethod(Class<T> clazz, List<T> input) {
    @SuppressWarnings("unchecked")
    T[] res = (T[]) Array.newInstance(clazz, input.size());

    int i = 0;
    for (T t : input) {
        res[i] = t;
        i++;
    }
    return res;
}