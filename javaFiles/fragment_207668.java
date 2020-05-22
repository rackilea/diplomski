static ListNode partition(ListNode head, int x) {
    ListNode ptr = head;
    ListNode small = new ListNode(0);
    ListNode big = new ListNode(0);
    ListNode dummy_1 = big;
    ListNode dummy_2 = small;
    while (ptr != null) {
        if (ptr.val < x) {
          small.next = ptr;
          small = small.next;
        } else {
          big.next = ptr;
          big = big.next;
        }
        ptr = ptr.next;
    }
    small.next = dummy_1.next;
    big.next = null;
    return dummy_2.next;
}