static <T> List<T> trim2(List<T> list, Predicate<T> isEmpty) {
    ListIterator<T> it = list.listIterator();
    while (it.hasNext() && isEmpty.test(it.next())) {
        it.remove();
    }
    it = list.listIterator(list.size());
    while (it.hasPrevious() && isEmpty.test(it.previous())) {
        it.remove();
    }
    return list;
}