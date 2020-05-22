public class Tree<K, V> {

    private abstract class Node<T> extends Page<K, T> {}

    private final class InnerNode extends Node<Integer> {}

    private final class LeafNode extends Node<V> {}
}