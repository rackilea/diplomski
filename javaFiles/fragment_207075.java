void reverse() {
    link previous = null, temp = null;
    while (!isEmpty(head)) {
        temp = head.nextlink;
        head.nextlink = previous;
        previous = head;
        if (temp == null) {
           break;
        }
        head = temp;
    }

}