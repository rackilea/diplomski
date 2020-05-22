Link newNode = new Link(y);
// "first" requires a special treatment, as we need to replace the "first" value
if(first.data > y){
    // insert the new Link as first element
    newNode.next = first;
    first = newNode;
} else {
    // we need the previous Link, because previous.next will be set to the newNode
    Link previous = first;
    Link current = first.next;

    while (current != null) {
        if(current.data < y) {
            previous = current;
            current = current.next;
        } else {
            // we insert newNode between previous and current
            // btw. what should happen if current.data == y?
            previous.next = newNode;
            newNode.next = current;
            break; // we are done, quit the cycle
        }
    }
    // if the newNode.next is null at this point, means we have not inserted it yet.
    // insert it as the last element in the list. previous is pointing at it.
    if(newNode.next == null){
        previous.next = newNode;
    }
} // end of else