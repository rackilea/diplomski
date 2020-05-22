void reverseDisplay() {        
    System.out.println("The values of this linked list in reverse are: ");

    if (isEmpty())
        return;

    int numElements = 1;
    LLNode elem = front;
    while ((elem = elem.getLink()) != null) {
        numElements++;
    }
    // ...
}