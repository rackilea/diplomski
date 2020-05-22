@Override
public int hashCode()
{
    return 31 * x + y;
    // If using Java 7, this can be:
    // returns Objects.hash(x, y);
}

@Override
public boolean equals(final Object o)
{
    // No object instance is equal to null
    if (o == null)
        return false;
    // If the object is the same, this is true
    if (this == o)
        return true;
    // If not the same object class, false
    if (getClass() != o.getClass())
        return false;

    final Point other = (Point) o; // safe to cast since getClass() == o.getClass()
    return x == other.x && y == other.y; // test instance member equality
}