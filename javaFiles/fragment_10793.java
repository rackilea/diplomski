@SuppressWarnings("unchecked")
    public void printQueueData() {
        AtomicReference<Node> pointer = head;
        while (pointer.get() != null) {
            System.out.println(pointer.get().data);
            pointer = pointer.get().next;
        }
    }