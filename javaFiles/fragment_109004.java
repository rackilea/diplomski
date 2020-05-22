public T removeItem(){

    int n = array.length;
    T t = array[0];
    if(empty())
        return null;
    for(int i = 0; i < n -1; i++) {
        array[i] = array[i + 1];
    }
    numberOfItems--; // Missed piece
    return t;

}