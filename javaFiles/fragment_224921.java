public static ListNode toUpperCase(ListNode head) {
    if (head == null)
        throw new ListsException("Lists: null passed to copyUpperCase");

    ListNode newHead = null;
    ListNode current = null;

    char[] sss = toString(head).toCharArray();

    for (int i=0; i<sss.length; i++) {
        if (Character.isUpperCase(sss[i])) {
            if (current == null) {
                current = mkEmpty();
                newHead = current;
            } else {
                current.next = mkEmpty();
                current = current.next;
            }
            current.element = sss[i];
        }
    }
    return newHead;

}