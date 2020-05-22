public class SinglyLinkedList<E> {

    private class Node {
        private E element;
        private Node next;

        public Node(E e, Node n) {
            element = e;
            next = n;
        }

        public E getElement() { 
            return element; 
        }

        public Node getNext() { 
            return next; 
        }

        public void setNext(Node n) { 
            next = n; 
        }
    } 
}