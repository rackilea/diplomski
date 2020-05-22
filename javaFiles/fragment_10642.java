private boolean containsAll(List<?> a, List<?> b) {
    // List doesn't support remove(), use ArrayList instead
    ArrayList<Object> x = new ArrayList<Object>();
    ArrayList<Object> y = new ArrayList<Object>();

    x.addAll(a);
    y.addAll(b);
    for (Object o : y) {
        if (!x.remove(o)) // an element in B is not in A!
            return false;
    }
    return true;          // all elements in B are also in A
}