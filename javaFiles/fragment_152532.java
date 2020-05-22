public Element getEnd(){
    Element node = head;
    while(node!=null){
        System.out.println("node:" + node.getValue());
        node = head.getNext(); // head.getNext() always returns the same value
    }
    return node;
}