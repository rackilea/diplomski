@Override
public boolean equals(Object o) {
    if (o == null) {
        return false;
    }
    if (o == this) {
        return true;
    }
    if (o.getClass() != Point.class) {
        return false;
    }
    Point other = (Point) o;
    return other.x == this.x && other.y == this.y;
}

@Override
public int hashCode() {
    return Objects.hash(x, y);
}