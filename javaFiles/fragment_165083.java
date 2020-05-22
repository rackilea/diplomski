public void headAdd(Object o) {
    QueueNode temp = new QueueNode();
    temp.data = o;

    if (isEmpty()) {
        front = temp;
        rear = front;
        front.link = null;
        rear.link = null;
    } else {
        temp.link = front; 
        front = temp;
    }

    count++;
}