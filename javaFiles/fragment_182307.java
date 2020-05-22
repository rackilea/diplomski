class LastElementsStore<T> {
  Object[] arr;
  int size;
  int nextPutIndex;

  LastElementsStore(int size ) {
    arr = new Object[size];
    this.size = size;
  }

  void put(T elt) {
    arr[nextPutIndex] = elt;
    nextPutIndex++;
    if (nextPutIndex == size) {
      nextPutIndex = 0;
    }
  }

  // getters of your choice

}