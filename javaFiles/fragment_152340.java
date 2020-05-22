public static Object[] genericMethod(List input) {
    Object[] res = new Object[input.size()];

    int i = 0;
    for (Object t : input) {
        res[i] = t;
        i++;
    }
    return res;
}