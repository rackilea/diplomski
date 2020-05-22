import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenericNode {

    public static abstract class AbstractNode<V, N> {
        private V value;
        private List<N> children;

        public AbstractNode(V value, N... children) {
            this.value = value;
            this.children = children != null ? Arrays.asList(children)
                    : Collections.<N> emptyList();
        }

        public V getValue() {
            return value;
        }

        public List<N> getChildren() {
            return children;
        }

        public int getNumberOfChildren() {
            return children.size();
        }

        @Override
        public String toString() {
            return value.toString() + "->" + children.toString();
        }
    }

    // leaf node type, ignore type of children
    public static class NodeB extends AbstractNode<String, Object> {

        public NodeB(String value, Object... nodes) {
            super(value, nodes);
        }
    }

    // example of typical node in the mid of tree
    public static class NodeA extends AbstractNode<String, NodeB> {
        public NodeA(String value, NodeB... nodes) {
            super(value, nodes);
        }
    }

    // top level node type
    public static class Tree extends AbstractNode<String, NodeA> {
        public Tree(String value, NodeA... nodes) {
            super(value, nodes);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <V, N extends AbstractNode> int getNodeCount(
            AbstractNode<V, N> node) {
        int nodeCount = node.getChildren().size();
        for (N child : node.getChildren()) {
            nodeCount += getNodeCount(child);
        }
        return nodeCount;
    }

    public static void main(String[] args) {
        NodeB nodeB1 = new NodeB("Leaf node 1");
        NodeB nodeB2 = new NodeB("Leaf node 2");
        NodeA nodeA = new NodeA("Node with children", nodeB1, nodeB2);
        NodeA emptyNodeA = new NodeA("Empty node");
        Tree tree = new Tree("Tree", nodeA, emptyNodeA);
        System.out.println(tree);
        System.out.println(1 + getNodeCount(tree));
    }
}