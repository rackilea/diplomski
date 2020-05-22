public T remove (int index){
    if (index==0){
        //remove head
    }else if (index == size){
        //remove tail
    }
    else {
        Node<T> p = null;
        Node<T> q = null;
        Node<T> r = null;
        p = findNode(index-1); // finds the nodes previous to the node that needs to be removed
        q = p.next; //q is the node you want to remove
        r = q.next; //r is the node next to the node you want to remove

        p.next = r;
        r.previous = p;

        //you can explicitly delete the node, but GC will collect anyway. 
        q.next = null;
        q.previous = null;
        T value = q.value;
        q.value = null;
        return value;
    }
}