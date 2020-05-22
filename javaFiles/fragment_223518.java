@Override
public boolean equals(Object o) {
    if (o instanceof Pair) {
        Pair other = (Pair) o;
        return row == other.row && col == other.col;
    }
    return false;
}