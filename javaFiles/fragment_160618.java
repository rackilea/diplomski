public Link removeAll(int n)
{
    Link head = first;
    Link previous = null;
    Link current = first;

    while (current != null) {
        if (current.id == n) {
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
        } else {
            previous = current; // if we removed current, let previous remain the same
        }
        current = current.next;
    }
    first = head;
    return head;
}