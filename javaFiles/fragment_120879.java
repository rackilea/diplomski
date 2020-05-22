public static <E> FBag<E> make(Collection<E> c) {
    FBag<E> p = empty ();
    for (E a : c) {
        p = p.add(a);
    }
    return p;
}

public static <E> FBag<E> make(E[] c, int from, int to) {
    FBag<E> p = empty ();
    for (int i = from; i < to; i++) {
        p = p.add(c[i]);
    }
    return p;
}