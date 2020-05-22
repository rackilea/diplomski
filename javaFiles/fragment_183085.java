public static void add(ListNode <Integer> head, Integer value) {
  if (head == null)
  {  
     head = new ListNode <Integer> (value, null);//creates new reference
     head.setNext(null);
  } else {
     while (head.getNext() != null)
     {
        head = head.getNext();
     }
     head.setNext(new ListNode <Integer> (value, null));
  }
}