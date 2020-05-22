@Override
public int hashCode() {
    return 31*x + y;
}
@Override
public bool equals(Object other) {
    if (other == null) return false;
    if (other == this) return true;
    if (!(other instanceof Point)) return false;
    Point p = (Point)other;
    return x == p.x && y == p.y;
}