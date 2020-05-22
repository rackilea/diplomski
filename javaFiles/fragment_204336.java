public class Q5 {
    private static BinTree root;

    public Q5(int ... args) {
        BinTree binTreeLeftChild,binTreeRightChild;
        root = new BinTree();       
        binTreeLeftChild = new BinTree();
        binTreeRightChild = new BinTree();
        root.value  = args[0];
        binTreeLeftChild.value = args[1];
        binTreeRightChild.value = args[2];
        root.left = binTreeLeftChild;
        root.right = binTreeRightChild;
    }
    private static class BinTree{
        private  BinTree left;
        private  BinTree right;
        private  int value;
        public BinTree() {
            // TODO Auto-generated constructor stub
            left = null;
            right = null;
            value = 0;
        }
    }
...
}