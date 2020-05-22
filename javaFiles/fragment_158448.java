public void add(String n) {
    NodeFN nn = new NodeFN(n);
    if(head == null) {
        head = nn;
    }

    // Don't use a while loop, there is nothing to repeat
    if (n.compareTo(head.getData()) < 0) {
        // Both these operations put 'nn' in beginning of the list.
        nn.setNext(head); 
        head = nn;
    }
}