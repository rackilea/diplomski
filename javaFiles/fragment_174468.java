@Override
public int compareTo(Coordinates o) {
    int cmp = row - o.row;
    if (cmp == 0)
        cmp = column - o.column;
    return cmp;
}