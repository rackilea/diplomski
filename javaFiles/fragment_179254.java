public void traverse (Node root){ // Each child of a tree is a root of its subtree.
    if (root.left != null){
        traverse (root.left);
    }
    System.out.println(root.data);
    if (root.right != null){
        traverse (root.right);
    }
}

// Search with a valid node returned, assuming int

public Node traverse (Node root, int data){ // What data are you looking for again?
    if(root.data == data) {
        return root;
    }
    if (root.left != null){
        return traverse (root.left, data);
    }
    if (root.right != null){
        return traverse (root.right, data);
    }
    return null;
}