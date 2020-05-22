if (val != null) {
    for (ListIterator<E> it = list.listIterator(); it.hasNext(); )
        if (val.equals(it.next()))
            it.set(newVal);
} else {
    for (ListIterator<E> it = list.listIterator(); it.hasNext(); )
        if (it.next() == null)
            it.set(newVal);
}