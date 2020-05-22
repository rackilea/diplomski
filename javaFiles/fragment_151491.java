public String toString() {
    if (head == null) {
        return "";
    }

    String result = "";

    Node temp = head;

    do {
        result += temp.toString();

        temp = temp.getNextNode();

    } while (head != tail && temp != head);
    return result;
}