public int getLength() {
    int Length = 0;
    Link temp = head.next;
    while (temp != null) {
        temp = temp.next;
        Length++;
    }

    return Length;
}