public static List ReverseRecursion(List head){
    List newHead;

    if(head == null){
        return null;
    }
    if(head.next == null){
        return head;
    }

    newHead = ReverseRecursion(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}