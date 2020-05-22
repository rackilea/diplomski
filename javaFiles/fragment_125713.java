@Override
public int compare(final Field lhs, final Field rhs) {
    int firstCompareValue = lhs.getPropA().compareTo(rhs.getPropA());

    if (firstCompareValue == 0) {
        // lhs and rhs are equals in propA, use propB
        int secondCompareValue = lhs.getPropB().compareTo(rhs.getPropB());
        return secondCompareValue;
    } else {
        return firstCompareValue;
    }
}