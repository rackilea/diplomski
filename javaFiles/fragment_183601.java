public void push(int value) {
    // resize if required
    if (size == maxSize){
        stackArray = Arrays.copyOf(stackArray, size * 2);
        maxSize = size * 2;
    }

    // then do the addition to the array stuff
    if (size != maxSize){ 
        top++;
        stackArray[top] = value;
        size++;
    } else {
        throw new RuntimeException();
    }
}