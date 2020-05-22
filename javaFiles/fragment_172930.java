public void display() {
    System.out.println("Queue display: ");
    for (int look = front; look < queueArray.length; look++) {
        System.out.println(" " + queueArray[look].getName());
    }

}