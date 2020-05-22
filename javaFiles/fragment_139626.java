@Override
public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
        return false;
    }
    Key key = (Key) o;
    return x == key.x && y == key.y;
}

@Override
public int hashCode() {
    return Objects.hash(x, y);
}