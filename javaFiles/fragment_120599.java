class Node {

private String name;
private Node leftChild;
private Node rightChild;
private Node parent;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Node getLeftChild() {
    return leftChild;
}

public void setLeftChild(Node leftChild) {
    this.leftChild = leftChild;
}

public Node getRightChild() {
    return rightChild;
}

public void setRightChild(Node rightChild) {
    this.rightChild = rightChild;
}

public Node getParent() {
    return parent;
}

public void setParent(Node parent) {
    this.parent = parent;
}

public void displayNode() {

    System.out.println(name);
}

}



public class Tree {

private Node root;

public Tree() {
    root = null;
}

public void insertRoot(String rootName) {
    if (root == null) {
        Node newNode = new Node();
        newNode.setName(rootName);
        root = newNode;
    } else {
        System.out.println("There is already a root");
    }
}

public void insertLeftChild(String parentName, String childName) {
    Node parent = parent(parentName, root);

    if (parent == null) {
        System.out.println("No such parent exists");
    } else if (parent.getLeftChild() == null) {

        Node newNode = new Node();
        newNode.setName(childName);

        parent.displayNode();

        newNode.setParent(parent);

        parent.setLeftChild(newNode);
        System.out.println("It worked");
    } else if (parent.getLeftChild() != null) {
        System.out.println("They already have a left child");
    }
}

public void insertRightChild(String parentName, String childName) {

    Node parent = parent(parentName, root);

    if (parent == null) {
        System.out.println("No such parent exists");
    } else if (parent.getRightChild() == null) {
        Node newNode = new Node();
        newNode.setName(childName);

        newNode.setParent(parent);
        parent.setRightChild(newNode);
    } else if (parent.getRightChild() != null) {
        System.out.println("They already have a right child");
    }
}

public Node parent(String parentName, Node root) {
    if (root != null) {
        if (root.getName().equals(parentName)) {
            return root;
        } else {
            Node found = parent(parentName, root.getLeftChild());
            if (found == null) {
                found = parent(parentName, root.getRightChild());
            }
            return found;
        }
    } else {
        return null;
    }
}

public static void main(String[] args) {

    Tree t = new Tree();

    t.insertRoot("1");

    t.insertLeftChild("1", "2");

    t.insertLeftChild("2", "3");

    t.insertLeftChild("3", "4");

    t.insertLeftChild("1", "3");

    t.insertRightChild("7", "8");
}
}