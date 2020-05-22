package rclib;
import java.util.*;

public class InorderIterator<T extends Comparable<T>> implements Iterator<Node<T>> {
    LinkedList<Node<T>> list;

    public InorderIterator(Node<T> root) {
        list = new LinkedList<Node<T>>();
        fillList(root);
    }

    public void fillList(Node<T> currentNode) {
        if (currentNode == null) return;
        fillList(currentNode.getLeft());
        list.add(currentNode);
        fillList(currentNode.getRight());
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public Node<T> next() {
        return list.removeFirst();
    }
}