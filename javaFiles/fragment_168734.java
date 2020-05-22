@Override
public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass())
        return false;

    Vector2d other = (Vector2d)obj;
    return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x) &&
           Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
}

@Override
public int hashCode() {
    int hash = 0x811C9DC5;
    hash ^= Double.hashCode(x);
    hash *= 0x01000193;
    hash ^= Double.hashCode(y);
    hash *= 0x01000193;
    return hash;
}