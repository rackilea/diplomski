public static void add(ListNode <Integer> head, Integer value) {
    while (head.getNext() != null){
        head = head.getNext();
    }
    head.setNext(new ListNode <Integer> (value, null));
}