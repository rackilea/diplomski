@Override
public int compareTo(Coordinates o) {
    int cmp = Integer.compare(row, o.row);
    if (cmp == 0)
        cmp = Integer.compare(column, o.column);
    return cmp;
}