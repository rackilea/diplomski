public void insertFirst(EltType first) {
    if(!isEmpty()) {
        EltType[] tempArray;
        tempArray = (EltType[]) new Object[capacity+1];
        for (int i=0;i<deque.length;i++) {
            tempArray[i+1] = deque[i]; 
        }

        deque = tempArray; 
    } 
    deque[0] = first;
}