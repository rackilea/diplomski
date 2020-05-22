public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    sb.append(head.data.toString());

    node n;
    while(n = head.getNext() != null)
        sb.append(", " + n.data.toString());

    sb.append("]");
    return sb.toString();
}