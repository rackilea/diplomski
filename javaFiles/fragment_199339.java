void deleteNode(int d){
    Node n = this;
    if(n.data == d){
        data = next.data;
        next = next.next;
        return;
    }

    while(n.next != null){
        if(n.next.data == d){
            n.next = n.next.next;
            return;
        }
        n = n.next;
    }
    return;
}