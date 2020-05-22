@Override
public int compareTo(Coordinates o) {
    if (row < o.row) return -1;
    if (row > o.row) return +1;

    if (column < o.column) return -1;
    if (column > o.column) return +1;
    return 0;
}