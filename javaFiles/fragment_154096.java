public void addLast(E newElem) {
    SNode<E> newNode = new SNode<E>(newElem);
    if(firstNode == null) {
        firstNode = newNode;
    } else {
        SNode<E> traveler = firstNode;
        for( ; traveler.nextNode != firstNode ; traveler = traveler.nextNode) {}
        traveler.nextNode = newNode;
    }
    newNode.nextNode = firstNode;
}