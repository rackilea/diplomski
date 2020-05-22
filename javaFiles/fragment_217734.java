public static <T> int frequency(Collection<T> c, T o, Comparator<? super T> comp) {
    int result = 0;
    if (o == null) {
        for (Object e : c)
            if (e == null)
                result++;
    } else {
        for (T e : c)
            if (comp.compare(e,o) == 0)
                result++;
    }
    return result;
}