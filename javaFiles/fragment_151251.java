public TableDeque (TableDeque copy)
{
    // copy properties from the source TableDeque to the new instance
    this.head = new Node(copy.getHead()); 
    this.tail = new Node(copy.getTail()); 
    head.join(tail);
    this.size = copy.getSize();  
    this.setImage(copy.getImage());

}