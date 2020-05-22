void pushnth(int item, int pos){

    Node cur=new Node();
    cur.data=item;
    Node temp=head;
    int i=0;

    while(i<pos-2){ // note that I changed the end condition
        temp=temp.next;
        i++;
    }
    // the new node is placed between temp and temp.next
    cur.next = temp.next;
    temp.next = cur;
}