while(p.next != null){
            if(p.next.key == key){
                LinkedListNode next = p.next;
                p.next = next.next; 
            }else{
                p = p.next;
            }
            return;  //--> why are you returning here ... Line 1
        }