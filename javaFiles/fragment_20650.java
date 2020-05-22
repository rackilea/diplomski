public static <E> E findFirst(List<E> list, Class<E> itemType) {
    for (E element : list) {
        if (itemType.isInstance(element)) {
            return element;
        }
    }
    return null;
}