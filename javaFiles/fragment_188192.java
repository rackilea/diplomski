abstract class AbstractNode {
    int midRange;
}

class InnerNode extends AbstractNode {
    AbstractNode left;
    AbstractNode right;
    AbstractNode subtree;
}

class LeafNode extends AbstractNode {
    LeafNode next;
    LeafNode prev;
    Object data;
}