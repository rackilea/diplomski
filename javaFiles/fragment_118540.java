public T dequeue() {
    if (isEmpty()) {
        throw new NoSuchElementException("The queue is empty!");
    }

    T result = lastNode.getNextNode().getData();

    if (lastNode.getNextNode() == lastNode) {
        lastNode = null;
    } else {
        lastNode.setNextNode(lastNode.getNextNode().getNextNode()); 
    }
    return result;
}