public void enqueue(Object newItem) {
    if (!isFull()) {
        back = (back + 1) % QUEUE_SIZE;
        items[back] = newItem;
        count++;
        return;
    }
    else {
        System.out.println("Queue is full. Doubling the size.");
        QUEUE_SIZE = (QUEUE_SIZE * 2); // double queue size not count 
        System.out.println("New max size is: " + QUEUE_SIZE);
        Object[] temp = new Object[QUEUE_SIZE]; // temp array
        System.arraycopy(items, front, temp, front, items.length - front); // copy the elements from front index to items.length-front
        if (front != 0) {
            System.arraycopy(items, 0, temp, items.length, front); // copy the elements in the range items[0] to items[back] into the new array
        }
        items = temp; // set items to temp array
        back = front + count;
        items[back] = newItem; // set new item 
        count++; // increment count
    }

}