static <T> Collection<T> asCollection(final ClosableIterator<? extends T> it) {
    Collection<T> toReturn = new HashSet<>();
    while (it.hasNext())
        if(true)
            toReturn.add((T) it.next());

    it.close();

    return toReturn;
}