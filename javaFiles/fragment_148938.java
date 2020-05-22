public IntSet subtract(IntSet other) {
    IntSet newSet = new IntSet (this);
    for(int iteration = 0; iteration < MAXALLOWEDSETVALUE; iteration++) {
        if(other.data[iteration]) {
            newSet.data[iteration] = false;
        }
    }
    return newSet;
}