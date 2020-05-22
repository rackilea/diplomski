@Override
public String toString() {
    StringBuilder sb = new StringBuilder("[");
    if (first != null) {
        Node temp = first;
        String sep = "";
        while (temp != null) {
            sb.append(sep).append(temp.value);
            temp = temp.next;
            sep = ", ";
        }
    }
    return sb.append(']').toString();
}