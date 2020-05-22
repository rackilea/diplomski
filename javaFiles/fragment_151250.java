public TableDeque (TableDeque copy)
{
    // copy properties from the source TableDeque to the new instance
    this.head = copy.getHead(); //this function returns the `head` property of TableDeque class
    this.tail = copy.getTail(); //this function returns the `tail` property of TableDeque class
    head.join(tail);
    this.size = copy.getSize();  //this function returns the `size` property of TableDeque class
    this.setImage(copy.getImage()); //this function returns the `image` property of TableDeque class

}