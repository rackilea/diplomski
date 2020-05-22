private void insert(Node<E> curr, E data){
    if (curr.next == null) {
        curr.next.data = data; //only inserts if next value is null
    } else { // what about inserting 3, into a list of {1,5}. 
        curr.next.insert(curr, data);
    }
}