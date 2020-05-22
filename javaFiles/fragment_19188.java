int shortestPath(int i, int j) {
    int path = 0;
    boolean b;
    while (i != j) {
        b = i > j;
        i >>= (b ? 1 : 0);
        j >>= (!b ? 1 : 0);
        path++;
    }
    return path;
}