public void addToTail (int el) {
        if (!isEmpty ( )) {
        tail = new Node (el, null, tail);
        tail.prev.next = tail;
        } 
        else head = tail = new Node(el);
    }