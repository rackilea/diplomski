public int insertBS(long value) {
    int curIn = find(value); // find where it goes (binary search)
    for(int k=nElems; k>curIn; k--) // move bigger one up
        a[k] = a[k-1];
    a[j] = value; // insert it
    nElems++; // increment size

}