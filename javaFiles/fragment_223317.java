public class Stack<E> implements Iterable<E>
{
    private int N;
    private Node<E> first;

    private class Node<T>
    {
        private T item;
        private Node<T> next;
    }
}