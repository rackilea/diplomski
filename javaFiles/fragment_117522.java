public static ListNode copyUpperCase(ListNode head) {
    ListNode ptr = head;
    while(!isEmpty(ptr.next)){
        if(!Character.isUpperCase(ptr.element)){
            ptr.next = ptr.next.next;
            //System.out.println(ptr.element);
        }
        ptr = ptr.next;
    }
    return head;
}