String GetPath (int i, int j) {
    if (path[i][j] == INF) return "no path";
    int intermediate = next[i][j];
    if (intermediate < 0) return " ";
    return GetPath(i,intermediate) + intermediate + GetPath(intermediate,j);
}