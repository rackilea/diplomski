public void addFirst(E item) {
if (item.equals(null)) { throw new NullPointerException(); }

        Node node = new Node(item, null);
        Node ptr = first;

        ptr.next.prev = node;
        node.prev = ptr;
        node.next = ptr.next;
        ptr.next = node;

    }