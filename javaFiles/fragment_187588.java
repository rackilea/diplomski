import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author jk
 */
public class BSTIterator<T> implements Iterator<T> {

    public static final class BST<T> {

        private BST<T> left;
        private BST<T> right;
        private T word;

        private BST(T word) {
            this.word = word;

        }

    }
    private final Stack<BST<T>> stackBST = new Stack<>();

    public BSTIterator(final BST<T> root) {
        // push all most left entries of the tree to the stack
        BST<T> currBST = root;
        while (currBST != null) {
            stackBST.push(currBST);
            currBST = currBST.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stackBST.isEmpty();
    }

    @Override
    public T next() {
        BST<T> currBST = stackBST.pop();

        // check if we are on the most right entry
        final boolean notMostRightEntry = currBST.right != null;
        if (notMostRightEntry) {
            // take next right entry 
            BST<T> nextBST = currBST.right;
            while (nextBST != null) {
                // push this next right entry on the stack
                stackBST.push(nextBST);
                nextBST = nextBST.left;
            }
        }
        return currBST.word;
    }

    public static void main(String[] args) {
        BST<Integer> root = new BST<>(20);
        root.left = new BST<>(5);
        root.right = new BST<>(30);
        root.left.right = new BST<>(10);
        root.right.left = new BST<>(25);
        root.right.right = new BST<>(40);
        root.right.left = new BST<>(35);
        root.right.left.left = new BST<>(32);
        for (Iterator<Integer> bstIt = new BSTIterator<>(root); bstIt.hasNext();) {
            System.out.println("val: " + bstIt.next());

        }
    }

}