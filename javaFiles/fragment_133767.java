public void remove(T elem)
{
    removeHelper(null, this.head, elem);
}

private void removeHelper(Node<T> prev, Node<T> head, T elem)
{
    if (head != null) {
        if (head.value.equals(elem)) {
            if (head == this.head) {
                this.head = head.next;
            } else {
                prev.next = head.next;
            }
            if (this.last == head) {
                this.last = prev;
            }
            --this.length;
        } else {
            prev = head;
        }
        removeHelper(prev, head.next, elem);
    }
}