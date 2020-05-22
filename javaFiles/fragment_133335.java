public void transferFrom(LinkedIntList list2) {

   if (front == null) {
       front = list2.front;
   } else {
       // Point to first node of list1
       ListNode current = front;

       // Move to the last node of list1
       while(current.next != null) {
          current = current.next;
       }

       // Last node of list1 -> firs node of list2
       current.next = list2;
   }

   // empty out list2
   list2.front = null;

}