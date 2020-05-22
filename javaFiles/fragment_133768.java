private void remove(T elem)
{
    Node<T> prev = null;
    Node<T> curr = this.head;
    while (curr != null) {
        if (curr.value.equals(elem)) {
            if (this.last == curr) {
                this.last = prev;
            }
            if (prev == null) {
                this.head = curr.next;
            } else {
                prev.next = curr.next;
            }
            --this.length;
        } else {
            prev = curr;
        }
        curr = curr.next;
    }
}