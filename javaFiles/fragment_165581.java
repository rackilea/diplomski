public void insert(E x) {
    q.add(binarySearch(x), x);
}

private int binarySearch (E x) {
    int low = 0;
    int high = q.size() - 1;
    while (high >= low) {
        int middle = (low + high) / 2;
        if (q.get(middle).getPriority() < x.getPriority()) {
            high = middle - 1;
        } else {
            low = middle + 1;
        }
    }
    return low;
}