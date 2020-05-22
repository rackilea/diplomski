public void **add**(Object ele){
        if(first==null){
            first=new Node(ele); //First
            last=first;
            count++;
        }
        last.next=new Node(ele); //second.
        last=last.next;
        count++;
    }