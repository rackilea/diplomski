public class BinNode {
    public int element;
    public BinNode left, right;


    public BinNode(int e, BinNode l, BinNode r) {
        element = e;
        left = l;
        right = r;
    }

    public BinNode(int e) {
        element = e;
        left = null;
        right = null;
    }

    public static int countOdd(BinNode root) {
        return countOdd_rek(root);
    }

    private static int countOdd_rek(BinNode bn) {
        if (bn == null) {
            return 0;
        }


        if (bn.element % 2 != 0) {
            //add +1 if root is also odd
            return 1 + countOdd_rek(bn.left) + countOdd_rek(bn.right);
        } else {
            return countOdd_rek(bn.left) + countOdd_rek(bn.right);
        }
    }

    public static void main(String[] args) {
        BinNode root = new BinNode(1,
                new BinNode(2,
                        new BinNode(4, null, null),
                        new BinNode(5, null, null)),
                new BinNode(3,
                        new BinNode(6, null, null),
                        new BinNode(7, null, null)));

        System.out.println(countOdd(root));
    }
}