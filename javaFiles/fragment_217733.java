public static int frequency(Collection<?> c, Object o) {
    int result = 0;
    if (o == null) {
        for (Object e : c)
            if (e == null)
                result++;
    } else {
        for (Object e : c)
            if (o.equals(e))
                result++;
    }
    return result;
}