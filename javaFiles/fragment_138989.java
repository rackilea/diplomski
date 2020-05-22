private void insert(E x) {
    items[putIndex] = x;
    putIndex = inc(putIndex); // <<== Wraps around
    ++count;
    notEmpty.signal();
}