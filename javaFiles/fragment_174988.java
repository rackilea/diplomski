while(pq.size() >0 ){
    System.out.println(pq.size());
    ListNode nextTemp = pq.poll();
    pointer.next = nextTemp;
    pointer = pointer.next;
}

pointer.next = null;  // terminate the list!!
return result;