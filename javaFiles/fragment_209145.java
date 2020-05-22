boolean get(int mySet, int index) {
    return (mySet & (1<<index)) != 0;
}
void set(int mySet, int index) {
    mySet |= (1<<index);
}
void clear(int mySet, int index) {
    mySet &= (1<<index);
}