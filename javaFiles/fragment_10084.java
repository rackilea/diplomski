public void insert(Node head,int a,int before){
    Node prev = null;
    while(head!=null){
        // Matched at head;
        if(prev==null && head.a==before){
            Node fresh = new Node(a);
            fresh.next=head;
            head=fresh;
            break;
        } else if(head.a==before){
            Node fresh = new Node(a);
            fresh.next=head;
            prev.next = fresh;
            break;
        }
        prev = head.next;
        head = head.next;

    }
}