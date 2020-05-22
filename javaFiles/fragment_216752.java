public SLLSet(int[] sortedArray){ //second constructor
    head = null;
    if (sortedArray == null || sortedArray.length == 0) {
        setSize = 0;
    }
    setSize = sortedArray.length;
    head = new SLLNode(sortedArray[0], null);
    SLLNode curr = head;

    for (int i=1; i < setSize; ++i) {
        curr.next = new SLLNode(sortedArray[i], null);
        curr = curr.next;
    }
}