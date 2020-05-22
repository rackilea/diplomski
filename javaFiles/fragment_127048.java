public void delete(int position){
        if (head == null || n <= 0) 
            return; 
        Node current = head; 
        int i; 
        for (i = 1; current != null && i < position; i++) 
        { 
            current = current.next; 
        } 
        if (current == null) 
            return; 
        head = deleteNode(head, current); 
    }