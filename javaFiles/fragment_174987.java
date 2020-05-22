ListNode result = sortList(head);
System.out.println("Sorted list is:"); // start output
while(result != null){
    System.out.println(result.val);
    result = result.next;
}