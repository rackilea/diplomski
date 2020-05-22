@Override
public int compare(final Field lhs, final Field rhs, final boolean firstUseDscOrder, final boolean secondUseDcsOrder) {
    PropertyComparator firstComparator = new PropertyComparator();
    firstComparator.setUseDscOrder(firstUseDscOrder);

    int firstCompareValue = firstComparator.compare(lhs.getPropA(), rhs.getPropA());

    if (firstCompareValue == 0) {
        // lhs and rhs are equals in propA, use propB

        PropertyComparator secondComparator = new PropertyComparator();
        secondComparator.setUseDscOrder(secondUseDscOrder);

        int secondCompareValue = secondComparator.compare(lhs.getPropB(), rhs.getPropB());
        return secondCompareValue;
    } else {
        return firstCompareValue;
    }
}