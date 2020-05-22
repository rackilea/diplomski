public void inorderTraversal(Node node, String word) {
    // handle end of word
    if (node.value != 0) {
        System.out.println(word + node.character + ": " + node.value);
    }

    if(node.left != null) {
        inorderTraversal(node.left, word);
    }

    if (node.middle != null) {
        inorderTraversal(node.middle, word + node.character);
    }

    if(node.right != null) {
        inorderTraversal(node.right, word);
    }
}

public void traverse() {
    inorderTraversal(root, "");
}