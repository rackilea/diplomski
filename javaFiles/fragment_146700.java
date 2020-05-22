ListIterator<Integer> listIter = list.listIterator(0);
while (listIter.hasNext()) {
    Integer element = listIter.next();

    if (hasCertainProperty(element)) {
        listIter.remove();
        break;
    }
}