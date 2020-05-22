@Override
public boolean equals(Object o) {
    if (o == null) {
        return false;
    }
    if (!(o instanceof Point)) {
        return false;
    }
    return (x == ((Point) o).x && y == ((Point) o).y);
}