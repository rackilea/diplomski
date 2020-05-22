public void addAtRec(Object obj, int k, ListNode current)
    throws ListIndexOutOfBoundsException {
    //always use braces even for single line block of code
    if(current.nextNode == null && k != 0) {
        throw new ListIndexOutOfBoundsException();
    }
    if(k == 0) {
        ListNode l = new ListNode(obj);
        l.nextNode = current.nextNode;
        current.nextNode = l;
        //stopping the recursion
        return;
    }
    current = current.nextNode;
    //decrease k by 1 before calling your method recursively
    k--;
    addAtRec(obj, k, current);
}