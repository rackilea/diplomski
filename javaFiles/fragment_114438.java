public Object[] toArray() {
        int size = 1;
        Node curr = head;

        while (curr.getNext() != null) {
            size++;
            curr = curr.getNext();
        }

        Object[] arr = new Object[size];
        //arr[0] = head; // Shouldn't be arr[0] = head.getItem(); ???
        arr[0] = head.getItem();

        Node curr = head; // You should set curr to head;

        for (int i = 1; i < size; i++) {
            arr[i] = curr.getNext().getItem();
            curr = curr.getNext(); // Otherwise you can't go to next element;
        }
        return arr;
    }