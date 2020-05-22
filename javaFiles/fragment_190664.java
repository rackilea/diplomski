public void insertBefore(Node newNode, Node existingNode){
    Node current = head;
    Node prev = null;
    while(current != null){
        if(current.getItem().equals(existingNode.getItem())){
            prev.setNext(newNode);
            newNode.setNext(current);
            break;
        } else{
            prev = current;
            current = current.next();
        }
    }
}