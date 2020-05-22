LinkedStack stack;
LinearNode current = stack.getLinearNode();
while(current != null) {
    current.setElement(T); // I don't know what T is supposed to be here
    current = current.getNext();
}