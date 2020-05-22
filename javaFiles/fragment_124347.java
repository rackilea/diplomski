private BigDecimal getDistance(Point a, Point b) {
    BigDecimal dx = BigDecimal.valueOf(a.x - b.x);
    BigDecimal dy = BigDecimal.valueOf(a.y - b.y);
    BigDecimal distance = dx.pow(2).add(dy.pow(2));
    return distance;
}