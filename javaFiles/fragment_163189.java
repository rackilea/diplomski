interface Tree {
    Tree NULL_TREE = new NullTree();

    int countLeafs();
    Tree left();
    Tree right();
}

class NullTree implements Tree {
    @Override
    public int countLeafs() {
        return 0;
    }

    @Override
    public Tree left() {
        return this;
    }

    @Override
    public Tree right() {
        return this;
    }
}

class Leaf implements Tree {
    private int val;

    public Leaf(int val) {
        this.val = val;
    }

    public int countLeafs() {
        return 1;
    }

    @Override
    public Tree left() {
        return NULL_TREE;
    }

    @Override
    public Tree right() {
        return NULL_TREE;
    }
}

class Node implements Tree {

    private final int val;
    private final Tree left;
    private final Tree right;

    public Node(int val, Tree left, Tree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public int countLeafs() {
        return left.countLeafs() + right.countLeafs();
    }

    @Override
    public Tree left() {
        return left;
    }

    @Override
    public Tree right() {
        return right;
    }
}

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Tree t = new Node(5, new Leaf(10), new Leaf(20));
        System.out.println(t.countLeafs());
    }
}