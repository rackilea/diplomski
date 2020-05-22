public void add(int i, value_type value) {
    if (i < 0 || i > size())
        throw new IndexOutOfBoundsException();

    //if the size of the list is 0, create a new head
    if (n==0) {
        head = new ListNode<value_type>(value, head);
        tail = head;
    } else if (i==0) { //if the size isn't 0, but i is 0, add a new head
        ListNode<value_type> u = new ListNode<value_type>(value, head);
        head = u;
    } else if (i==n) { //if adding onto the end, make a new tail
        ListNode<value_type> u = new ListNode<value_type>(value);
        tail.next = u;
        tail = u;           
    } else { //else, traverse through the list to the appropriate spot
        ListNode<value_type> tmp;
        tmp = head;
        for(int k=0; k < i-1; k++) {
            tmp = tmp.next;
        }
        ListNode<value_type> u = new ListNode<value_type>(value, tmp.next);
        tmp.next = u;
    }

    n++; //increase the size of the list by 1

}