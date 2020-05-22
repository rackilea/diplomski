public void addLast(int element) {

        Node nodeToInsert = new Node();
        nodeToInsert.setItem(element);
        nodeToInsert.setBefore(tail); 
        nodeToInsert.setNext(null);

        if(tail != null)
          tail.setNext(nodeToInsert); //link the list

        tail = nodeToInsert; //now the tail is the new node i added

        if(head == null)       // if the list has no elements then set the head
             head = nodeToInsert;
}