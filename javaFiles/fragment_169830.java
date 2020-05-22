public IntSortedArray() {
    this.elements = new int[MAX];
    this.size = 0;
    for (int i=0 ; i < MAX ;i++) {
       elements[i] = i;
       size++;
    }
}