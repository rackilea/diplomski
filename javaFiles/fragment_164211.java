public class PQAVL<T extends Comparable<T>> {
    private AVLTree<T> avl;
    public PQAVL() {
        avl = new AVLTree<T>(true);
    }
}