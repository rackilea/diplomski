public void remove(T element)
{
     if(first == null) { // edge case - empty list
        return;
     }
     else if(first.value.equals(element)) { // edge case - removing the first element
        first = first.next;
        this.count--;
        return;
     }
    //Node<T> nn = new Node<T>(); // no need to create a new node, but rather remove an existing node.
    Node<T> cur = first.next;
    Node<T> prev = first;

    //nn.value = element; //no need to create a new node and set its value attribute

    boolean deleted = false;

    while(cur != null && deleted == false)
    {
           if(cur.value.equals(element)) //data cannot be resolved or is not a field
           {
               prev.next = cur.next;
               this.count--;
               deleted = true;
           }
           else { // added missing advancement of the loop iterator - cur. prev must also be advanced
             cur = cur.next;
             prev = prev.next;
           }
    }
    // This implementation adds the removed element to the end of the list, meaning
    // it is not a remove method, but rather a move to the end implementation.
    // In order to conform to what a remove method does, the last two code lines were commented out.
    //prev = gotolastnode(prev); 
    //prev.next = nn;
}