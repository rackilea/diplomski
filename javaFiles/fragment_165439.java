public LinkedList getTailOfListOfLengthN(LinkedList list, int n) {
    int length = getLength(list);
    if (length < n) {
        return null;
    } else if (length == n) {
        return list;
    } else {
        return getTailOfLengthN(list.getTail(), n);
    }
}