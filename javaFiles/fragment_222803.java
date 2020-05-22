import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {
    static class BTree {
        int node;
        BTree left, right;

        public BTree(int node) {
            this.node = node;
            this.left = this.right = null;
        }
    }

    static class Driver {
        BTree addNode(BTree root, int rootNode, char choice, int node) {
            if (root == null) {
                return root;
            }

            if (root.node == rootNode && choice == 'l') {
                root.left = new BTree(node);
            } else if (root.node == rootNode && choice == 'r') {
                root.right = new BTree(node);
            }

            root.left = addNode(root.left, rootNode, choice, node);
            root.right = addNode(root.right, rootNode, choice, node);

            return root;
        }

        void display(BTree root) {
            if (root == null)
                return;

            if (root.left != null)
                System.out.print(root.node + " ");

            if (root.right != null)
                System.out.print(root.right.node + " ");

            display(root.left);
            display(root.right);
        }

        boolean isPossible(BTree root, int key) {
            if (root == null)
                return false;

            if (root.node == key) {
                return true;
            }

            boolean flag = isPossible(root.left, key);
            if (!flag)
                flag = isPossible(root.right, key);

            return flag;
        }

        int findLcaDriver(BTree root, int n1, int n2) {
            Queue<LowestCommonAncestor.BTree> queue = new LinkedList<>();
            queue.add(root);

            int flag = -1;
            while (!queue.isEmpty()) {

                LowestCommonAncestor.BTree btree = queue.remove();
                // dive down and checking whether both nodes can be reach from
                // current node or not
                if (isPossible(btree, n2) && isPossible(btree, n1)) {
                    flag = btree.node;
                }
                if (btree.left != null)
                    queue.add(btree.left);

                if (btree.right != null)
                    queue.add(btree.right);
            }

            return flag;
        }
    }

    public static void main(String[] args) {
        Driver driver = new Driver();

        BTree root = new BTree(1);

        root = driver.addNode(root, 1, 'l', 2);
        root = driver.addNode(root, 1, 'r', 3);
        root = driver.addNode(root, 2, 'r', 5);
        root = driver.addNode(root, 5, 'l', 12);
        root = driver.addNode(root, 3, 'r', 4);
        root = driver.addNode(root, 3, 'l', 17);
        root = driver.addNode(root, 4, 'r', 11);
        root = driver.addNode(root, 4, 'l', 10);

        System.out.println("Lowest Common Ancestor of these two Nodes is: " + driver.findLcaDriver(root, 17, 4));
    }
}