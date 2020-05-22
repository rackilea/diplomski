public void addNode(Integer someData) {
    LinkedNode myNode = new LinkedNode(someData,null);
    //initialize node if this is first element
    if (head == null) {
        head = myNode;
        size++;
    }
    else if (head.getNext() == null) {
        head.setNext(myNode);
        size ++;
    }
    else if (head.getNext() != null) {
        System.out.println("in second else if");
        LinkedNode n = head;
        while(n.getNext() != null) {
            n = n.getNext();
        }
        n.setNext(myNode);
        size++;
    }

}