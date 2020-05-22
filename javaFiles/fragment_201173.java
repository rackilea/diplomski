public void addFront(int n){
    Node temp=new Node(n);
    if (llist==null){
        first=temp;
    }
    else{
        llist.next=temp;
    }
    llist=temp;
}

public void addBack(int n){
    Node temp=new Node(n);
    temp.next=first;
    first=temp;
    if (llist == null)
        llist = first;
}