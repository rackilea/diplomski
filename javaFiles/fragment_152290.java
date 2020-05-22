public static void Addtolist2(List list2, List list1) {
    // Find last node in list2
    ListNode lastEl = list2.header;
    while(lastEl != null) {
        lastEl = lastEl.next;
    }

    // Take the first element of list1
    ListNode firstEl = list1.header;

    // Add new element to list2 in last
    ListNode newEl = new ListNode();
    newEl.data = firstEl.data;
    lastEl = newEl;

    // Remove first element of list1 (replace with second)
    list1.header = firstEl.next;
}