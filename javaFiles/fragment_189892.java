Iterator<E> it = small.iterator();
while (it.hasNext()) {
    E e = it.next();
    if (!medium.contains(e) || !large.contains(e))
        it.remove();
}