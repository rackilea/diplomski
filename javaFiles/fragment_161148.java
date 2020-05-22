public void insertItemLast(Object newItem){
    if(newItem == null)
        return;//user inputs nothing
    else {
        Node P = new Node(newItem);
        P.next = null;
        if(head == null) {
            head = P;
            tail = P;
        } else {
            tail.next = P;
            tail = P;
        } 
    }
    numItems++;
}//end enqueque