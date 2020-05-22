private static AvlNode insert(int x, AvlNode t) {
    if (t == null && root==null)
        return (root = new AvlNode(x, null, null));
    else if (t==null) {
        return  new AvlNode(x, null, null);
    }

    t.height++;
    int compareResult = Integer.compare(x, t.key);
    if (compareResult < 0) {
        t.left = insert(x, t.left);
    } else if (compareResult > 0) {
        t.right = insert(x, t.right);
    } else {
        t.height--;
    }

        return balance(t);
    }

private static class AvlNode {
    int key;
    AvlNode left;
    AvlNode right;
    int height=0; 

    AvlNode(int x, AvlNode l, AvlNode r) {
        key = x;
        left = l;
        right = r;
        this.height++;
    }
}