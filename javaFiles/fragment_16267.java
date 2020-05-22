public static TreeNode postfixToTree(String s) {
    Stack<TreeNode> stree = new Stack<>();

    BST b = new BST();
    for (char ch : s.toCharArray()) {
        b.myInsert(ch, stree);
    }
    return stree.pop();
}

public static void main(String[] args) {
    System.out.println(postfixToTree("5372-*-"));
    System.out.println(postfixToTree("512+4*+3−"));
    System.out.println(postfixToTree("51*24*+"));
}