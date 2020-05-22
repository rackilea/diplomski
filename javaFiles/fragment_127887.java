public void sort() {
        if (size > 1) {
            for (int i = 0; i < size; i++ ) {
                Node currentNode = head;
                Node next = head.nextNode;
                for (int j = 0; j < size - 1; j++) {
                    if (currentNode.data > next.data) {
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;
                    } 
                    currentNode = next;
                    next = next.nextNode;                   
                } 
            }
        }
    }