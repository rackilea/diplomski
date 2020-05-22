private static class Node<V> {
        private final AtomicReference<Node> next = new AtomicReference<>();
        private final V data;
        private final String threadName;

        Node(V data1, String threadName) {
            this.data = data1;
            this.threadName = threadName;
        }
    }