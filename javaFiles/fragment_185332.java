public void addFront (E x){
    if(!isFull()) {
        if (head == 0) {
            head = deque.length-1;
            deque[head] = x;
        } else {
            deque[--head] = x;
        }
        counter++;
    }
    else throw new IndexOutOfBoundsException("Stack is full!");
}