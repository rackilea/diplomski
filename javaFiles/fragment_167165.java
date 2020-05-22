private void insertAtOccupied(Course course, int index) {
    Coursenode previous = null;
    Coursenode current = head;

    for (int i = 1; i <= index; i++) {
        // Track the previous and current nodes
        //   previous = node at i - 1
        //   current = node at i
        previous = current;
        current = current.next;
    }

    Coursenode insertedNode = new Coursenode(c, current.next);
    previous.next = insertedNode;
}