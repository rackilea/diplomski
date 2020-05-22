public class Stack<E> implements Iterable<E>
{
    private int N;
    private Node first;

    private class Node
    {
        private E item;
        private Node next;
    }
}