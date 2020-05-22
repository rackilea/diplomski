import java.util.LinkedList;

class BFSNode {
    int val;
    BFSNode parent;
    LinkedList<BFSNode> allChildren = new LinkedList<BFSNode>();
}

public class BFSTree {
    BFSNode root = null;

    public void add(int insertVal, int parentVal) {

        BFSNode newNode = new BFSNode();
        newNode.val = insertVal;
        BFSNode parentNode = null;

        if (root == null) {
            root = newNode;
            System.out.println("Added insertVal :" + insertVal + " at parent :"
                    + root.val);
        } else if (root.val == parentVal) {
            root.allChildren.add(newNode);
            System.out.println("Added insertVal :" + insertVal + " at parent :"
                    + root.val);
        } else {
            parentNode = BFS(parentVal);
            if (parentNode == null) {
                System.out.println("Parent does not exist");
            } else {
                parentNode.allChildren.add(newNode);
                System.out.println("Added insertVal :" + insertVal
                        + " at parent :" + parentNode.val);
            }

        }

    }

    public BFSNode BFS(int parentVal) {
        BFSNode markBfsNode = root;

        LinkedList<BFSNode> childrenQueue = new LinkedList<BFSNode>();

        while (true) {

            for (int i = 0; i < markBfsNode.allChildren.size(); i++) {
                if (markBfsNode.allChildren.get(i).val == parentVal) {
                    return markBfsNode.allChildren.get(i);
                } else {
                    childrenQueue.add(markBfsNode.allChildren.get(i));
                }
            }

            if (childrenQueue.getFirst() == null) {
                System.out.println("Element not found");
                return null;
            } else {
                markBfsNode = childrenQueue.getFirst();
                childrenQueue.poll();
            }

        }
    }

    public void printBFS() {
        BFSNode markBfsNode = root;

        LinkedList<BFSNode> childrenQueue = new LinkedList<BFSNode>();
        System.out.print(root.val + "   ");

        while (true) {

            for (int i = 0; i < markBfsNode.allChildren.size(); i++) {
                childrenQueue.add(markBfsNode.allChildren.get(i));
            }

            try {
                if (childrenQueue.getFirst() == (null)) {
                    return;
                } else {
                    System.out.print(childrenQueue.getFirst().val + "   ");
                    markBfsNode = childrenQueue.getFirst();
                    childrenQueue.poll();
                }
            } catch (Exception e) {
                return;
            }

        }

    }


}

class BFSImplementation {

    public static void main(String args[]) {
        BFSTree obj = new BFSTree();
        obj.add(5, 0);

        obj.add(7, 5);
        obj.add(9, 5);
        obj.add(11, 5);
        obj.add(15, 5);

        obj.add(17, 9);
        obj.add(19, 9);
        obj.add(21, 9);

        obj.add(23, 19);
        obj.add(27, 19);

        obj.add(29, 7);
        obj.add(31, 7);

        obj.add(33, 11);
        obj.add(35, 11);

        obj.add(37, 21);
        obj.add(39, 21);

        obj.add(111, 29);
        obj.add(111, 29);
        obj.add(111, 29);

        System.out.println();
        obj.printBFS();
    }
}