public Element getEnd(){
    Element node = head;
    while(node.getNext()!=null){
        System.out.println("node:" + node.getValue());
        node = node.getNext();
    }
    return node;
}