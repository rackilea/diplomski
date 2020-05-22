public void myInsert(char ch, Stack<TreeNode> s) {
    if (Character.isDigit(ch)) {
        // leaf (literal)
        s.push(new TreeNode(ch));
    } else {
        // operator node
        TreeNode tParent = new TreeNode(ch);

        // add operands
        tParent.right = s.pop();
        tParent.left = s.pop();

        // push result to operand stack
        s.push(tParent);
    }
}