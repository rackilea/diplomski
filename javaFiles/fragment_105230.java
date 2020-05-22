public int deleteFirst() {
    if (header == null)
        return -1;      // <- -1 indicates that list is empty, but it is better to throw RuntimeException here
    Link current = header; 
    header = header.next == null ? null : header.next; // <- check if header.next exists
    return current.data; 
}