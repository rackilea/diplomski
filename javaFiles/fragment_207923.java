@Override
public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + Double.hashCode(x);
    result = 31 * result + Double.hashCode(y);
    return result;
}

@Override
public boolean equals(Object obj) {
    return obj instanceof Coordinate && ((Coordinate) obj).getX() == x 
        && ((Coordinate) obj).getY() == y
        && ((Coordinate) obj).getName().equals(name);
}