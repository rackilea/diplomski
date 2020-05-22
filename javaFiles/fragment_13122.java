public <E> E[] getArray(Class<E> clazz, int size) {
    @SuppressWarnings("unchecked")
    E[] arr = (E[]) Array.newInstance(clazz, size);

    return arr;
}