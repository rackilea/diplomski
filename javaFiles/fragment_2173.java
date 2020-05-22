private int searchIndex(E item, Node<E> node, int index) {
    if (node == null) {     
        // ok you say that if list ended found index is -1, i.e. not found
        return -1;      
    }
    else if (item.equals(node.data)) {
        // item is found, but your result is 0?
        // your result should be index
        return 0;
    }
    else {
        // your return is an index, so you can't make math on result
        // also passing same index over and over again 
        return 1 + searchIndex(item, node.next, index);         
    }   
}