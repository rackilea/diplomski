public boolean add (int index, E elem) {
    Node<E> node = new Node<>(elem); // You don't need to split definition and initialization

    if(index >= size) {
        System.out.println("Index out of bounds");

        return false;
    }

    if (index == 0) {
        head = node;
        node.next = indices.get(1); // Why is the next the second item, not the first? Maybe `indices.get(0)`?
        node.prev = null;
        node.next.prev = node;
    } else if (index == (size - 1)) {
        Node<E> node1 = indices.get(index - 1);
        tail = node;
        node1.next = node;
        node.next = null;
        node.prev = node1;
    } else if (index > 0 && index < (size - 1)) {
        Node<E> node1 = indices.get(index - 1);
        Node<E> node2 = indices.get(index);
        node.next = node1; // Why is `node1`, not `node2`?
        node.prev = node2; // Vice versa

        node1.next = node;
        node2.prev = node;
    } else {
        return false;
    }
    // If result is `false` why do u to add your node?
    indices.add(index, node);
    ++size;
    System.out.println("Element " + elem + " added at the index: " + index);
    System.out.println("The size of the list now is: " + size);

    return true;
}