public void **add**(Object ele){
        if(first==null){
            first=new Node(ele);
            last=first;
            count++;
        } else {
          last.next=new Node(ele);
          last=last.next;
          count++;
        }
    }