public void swap(){
        ListNode node1;
        ListNode node2;
        ListNode prev;
        prev = this;
        while(true){
            node1 = prev.next;
            if(node1 == null)
                break;
            node2 = node1.next;
            if(node2 == null)
                break;
            node1.next  = node2.next;
            node2.next  = node1;
            prev.next   = node2;
            prev        = node1;
        }
    }