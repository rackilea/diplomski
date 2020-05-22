import java.util.Vector;

public class PartialTreeMatch {
    public static void main(String[] args) {
        Node testTree = createTestTree();
        Node searchTree = createSearchTree();

        System.out.println(testTree);
        System.out.println(searchTree);

        partialMatch(testTree, searchTree);
    }

    private static boolean partialMatch(Node tree, Node searchTree) {
        Node subTree = findSubTreeInTree(tree, searchTree);
        if (subTree != null) {
            System.out.println("Found: " + subTree);
            return true;
        }
        return false;
    }

    private static Node findSubTreeInTree(Node tree, Node node) {
        if (tree.value == node.value) {
            if (matchChildren(tree, node)) {
                return tree;
            }
        }

        Node result = null;
        for (Node child : tree.children) {
            result = findSubTreeInTree(child, node);

            if (result != null) {
                if (matchChildren(tree, result)) {
                    return result;
                }
            }
        }

        return result;
    }

    private static boolean matchChildren(Node tree, Node searchTree) {
        if (tree.value != searchTree.value) {
            return false;
        }

        if (tree.children.size() < searchTree.children.size()) {
            return false;
        }

        boolean result = true;
        int treeChildrenIndex = 0;

        for (int searchChildrenIndex = 0;
                 searchChildrenIndex < searchTree.children.size();
                 searchChildrenIndex++) {

            // Skip non-matching children in the tree.
            while (treeChildrenIndex < tree.children.size()
                  && !(result = matchChildren(tree.children.get(treeChildrenIndex),
                                              searchTree.children.get(searchChildrenIndex)))) {
                treeChildrenIndex++;
            }

            if (!result) {
                return result;
            }
        }

        return result;
    }

    private static Node createTestTree() {
        Node subTree1 = new Node('A');
        subTree1.children.add(new Node('A'));
        subTree1.children.add(new Node('A'));

        Node subTree2 = new Node('A');
        subTree2.children.add(new Node('A'));
        subTree2.children.add(new Node('C'));
        subTree2.children.add(subTree1);

        Node subTree3 = new Node('B');
        subTree3.children.add(subTree2);

        Node root = new Node('A');
        root.children.add(subTree3);

        return root;
    }

    private static Node createSearchTree() {
        Node root = new Node('A');
        root.children.add(new Node('A'));
        root.children.add(new Node('A'));

        return root;
    }
}

class Node {
    char value;
    Vector<Node> children;

    public Node(char val) {
        value = val;
        children = new Vector<Node>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append('(');
        sb.append(value);

        for (Node child : children) {
            sb.append(' ');
            sb.append(child.toString());
        }

        sb.append(')');

        return sb.toString();
    }
}