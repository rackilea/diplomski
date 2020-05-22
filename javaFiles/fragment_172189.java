private static class Node<E> {

    private E data;
    private Node<E> next;

    private Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }   
}