@Override
public boolean equals(Object o)
{
    if (o == this)
        return true;
    if (!(o instanceof Point))
        return false;
    Point other = (Point) o;
    return this.x == other.x && this.y == other.y;
}