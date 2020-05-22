private void insert(Node current, Node temp) {
    if(current == null)
        current = temp;
    else if(temp.element < current.element)
        insert(current.leftChild, temp);
    else if(temp.element >= current.element)
        insert(current.rightChild, temp);
}