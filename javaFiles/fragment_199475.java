public E removeFirst() {
            E value=first.val;
           if (size>=2)
           {
           first=first.next;                            
           }
           else if (size==1)
           {
            last=null;
           }
            size--;                
            return value;
    }