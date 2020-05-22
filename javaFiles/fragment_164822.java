while (head.getNext() != null) {
        head = head.getNext();

        if (head.getElement() == data) {
            System.out.println(head);                
            return true;                               
        }             
    }