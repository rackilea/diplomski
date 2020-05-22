/* 6. Else traverse till the last node */
        Node last = head;
        while (last.next != null)
            last = last.next;

        /* 7. Change the next of last node */
        last.next = new_node;