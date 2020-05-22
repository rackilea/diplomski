public Comparable pop(Comparable obj) {

    for (OrderedListNode element = head.next; element != tail; element = element.next) {

        Comparable temp = null;     // declaration of the temporary object

        if (obj.equals(element.dataItem)) { // if element being removed is
                                            // at the cursor

            temp = obj;                     // store obj in temp

            OrderedListNode previousNode = element.before;
            OrderedListNode nextNode = element.next;

            nextNode.before = previousNode; // places next element that's
                                            // after before to the element
                                            // after current element [prev
                                            // -> current -> next]

            previousNode.next = nextNode;   // places prev of next element to
                                            // the element before current

            element.dataItem = (Comparable) NOT_FOUND;  // removed element is
                                                        // now null

            modCount++; // another modification
            theSize--; // reduce the size by 1

            return temp; // if remove is successful
        }
    }
    return null; // otherwise, not successful removal
}