public void remove() {
    if(current > 0) {
        for (int i=current-1; i<size-1; i++)
            data[i] = data[i+1];
        size--;
    }
}