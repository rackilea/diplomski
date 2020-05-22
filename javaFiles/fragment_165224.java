if (head == null) return head;

ListNode dummy = new ListNode(head.val - 1);
dummy.next = head;

ListNode node = dummy;
while (node.next != null && node.next.next != null) {
    if (node.next.val != node.next.next.val) {
        node = node.next;
    } else {
        int val = node.next.val;
        node.next = node.next.next.next;
        while (node.next != null && node.next.val == val) {
            node.next = node.next.next;
        }
    }
}

return dummy.next;