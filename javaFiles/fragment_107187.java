public <T> T[] toArray(T[] a) {
    // Estimate size of array; be prepared to see more or fewer elements
    int size = size();
    T[] r = a.length >= size 
        ? a 
        : (T[]) Array.newInstance(a.getClass().getComponentType(), size);
    Iterator<E> it = iterator();

    for (int i = 0; i < r.length; i++) {
        if (!it.hasNext()) { // fewer elements than expected
            if (a != r)
                return Arrays.copyOf(r, i);
            r[i] = null; // null-terminate
            return r;
        }
        r[i] = (T) it.next();
    }
    return it.hasNext() ? finishToArray(r, it) : r;
}