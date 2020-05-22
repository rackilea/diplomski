Shape s1, s2 ...
Rectangle2D r1 = s1.getBounds2D();
Rectangle2D r2 = s2.getBounds2D();
Rectangle2D r3 = new Rectangle2D.Double();
Rectangle2D.intersect(r1, r2, r3);
double overlap = area(r3) / (area(r1) + area(r2));
...
private double area(Rectangle2D r) {
    return r.getWidth() * r.getHeight();
}