public static int removeMin() {
    sizeOfTree--;
    int toReturn = heap[1];
    if(sizeOfTree > 1){
        heap[1] = heap[sizeOfTree];
        downHeap(1);
    }
    System.out.println(toReturn);
    return toReturn;
}