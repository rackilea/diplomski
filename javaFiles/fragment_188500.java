public interface Stack<E> {
    E push(E item);
    E pop();
}

public class VectorStack<E> implements Stack<E> {
    private Vector<E> backingVector = new Vector<>();

    ...
}

Stack<E> stack = new VectorStack<>();