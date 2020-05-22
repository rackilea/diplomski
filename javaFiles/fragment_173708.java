public static<E extends Comparable<E>> List<E> mergeSortedLists(List<E> a, List<E> b) {
    List<E> result = new ArrayList<E>();

    PushbackIterator<E> aIter = new PushbackIterator<E>(a.iterator());
    PushbackIterator<E> bIter = new PushbackIterator<E>(b.iterator());

    while (aIter.hasNext() && bIter.hasNext()) {
        E aElem = aIter.next();
        E bElem = bIter.next();
        if (aElem.compareTo(bElem) <= 0) {
            result.add(aElem);
            bIter.pushback(bElem);
        } else {
            result.add(bElem);
            aIter.pushback(aElem);
        }
    }

    while (aIter.hasNext()) {
        result.add(aIter.next());
    }
    while (bIter.hasNext()) {
        result.add(bIter.next());
    }

    return result;
}