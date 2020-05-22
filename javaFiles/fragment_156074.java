public Numbers(int size){
    this.size = size;
    this.arr = new Integer[size];
    for (int i = 0; i < size; i++){
        arr[i] = new Integer(i);
    }
}