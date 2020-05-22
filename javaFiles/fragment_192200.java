public int compare(Object o1, Object o2) throws UnsupportedOperationException {

    BitSet orderingBits = new BitSet();

    // get iterator for a List of comparators
    Iterator comparators = comparatorList.iterator();
    for (int comparatorIndex = 0; comparators.hasNext(); ++comparatorIndex) {

        Comparator comparator = (Comparator) comparators.next();
        int retval = comparator.compare(o1,o2);
        if (retval != 0) {
            // invert the order if it is a reverse sort
            if (orderingBits.get(comparatorIndex) == true) {
                retval *= -1;
            }

            return retval;
        }

    }

    // if comparators are exhausted, return 0
    return 0;
}