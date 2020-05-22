class ListNode {
    int value;
}

ListNode first = new ListNode();
ListNode second = first;
first.value = 42;
System.out.println(second.value);  //42