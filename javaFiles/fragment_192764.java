private class Node<T>{
        private Node<T> next;
        private T data;

        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }