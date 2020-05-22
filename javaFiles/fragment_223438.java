public int indexOf(int x) {
    return indexOf(x, first, 0);   
}

private static int indexOf(int x, Node n, int depth) {
    if (n==null) {
        return -1;
    }
    else if (n.data==x) {
        return depth;
    }
    else return indexOf(x, n.next, depth + 1);
}