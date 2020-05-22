public void deleteFromEnd() {
        Node start = head;
        Node prev = null;

        if(start == null || start.next == null)
        {
            head = null;
            return;
        }
        while (start.next != null) {
            prev = start;
            start = start.next;
        }
        prev.next = null;
    }