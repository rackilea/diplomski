public String toString() {

    if (isEmpty()) {
        return " ";
    }

    StringBuilder sb = new StringBuilder();
    LinearNode<T> next = head;

    while(next != null){
        sb.append(" ").append(next.getElement());
        next = next.getNext();
    }

    return sb.toString();

} // End of toString method