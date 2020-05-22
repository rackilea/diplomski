@Override
public int compare(Point o1, Point o2) {
    BigDecimal d1 = getDistance(o1);
    BigDecimal d2 = getDistance(o2);
    return d1.compareTo(d2);
}