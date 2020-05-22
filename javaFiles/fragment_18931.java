public class RedBlackTree<I extends Comparable<I>>

private class RedBlackNode implements Comparable<RedBlackNode>

    @Override
    public int compareTo(RedBlackNode node)
            int result = id.compareTo(node.id);
            return result > 0 ? 1 : result < 0 ? -1 : 0;