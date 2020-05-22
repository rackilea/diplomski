public void addfirst(E value) {
        Node<E> newNode = new Node(value, null);
        newNode.next = head;
        head = newNode;
        size = size + 1;
        if (size == 1)
            tail = head;
    }