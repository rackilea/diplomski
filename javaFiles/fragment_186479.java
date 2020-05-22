static LinkedListNode sort(int k, LinkedListNode list) {
    LinkedListNode end = list;
    for (int i = 0; i < k - 1 && end.next != null; i++) {
        end = end.next; // get end of first group
    }
    if (end.next == null) {
        return mergeSort(list); // if last group, sort and return
    }

    LinkedListNode rest = sort(k, end.next); // sort rest of list
    end.next = null; // split first group from list
    list = mergeSort(list); // sort first group

    end = list;
    while (end.next != null) {
        end = end.next; // get end of sorted first group
    }
    end.next = rest; // rejoin sorted rest of list to sorted first group

    return list;
}