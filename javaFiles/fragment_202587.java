public static void printTest(NaryTreeNode root) {

    // If you don't need to know the depth, no need for the "Pair" class, you could use Stack<NaryTreeNode>
    // You could also use a Hashmap(node -> depth) if you'd rather not create a new class
    Stack<Pair> stack = new Stack<>();

    stack.push(new Pair(root, 0));
    while(!stack.empty()){
        Pair current = stack.pop();
        NaryTreeNode node = current.node;
        int depth = current.depth;
        printWithSpaces(depth, node.LABEL);

        // If you don't care about the order, you could simply replace this block by
        // stack.addAll(node.getChildren())
        ArrayList<NaryTreeNode> children = node.getChildren();
        for (int i = children.size() - 1; i >= 0; i--) {
            stack.push(new Pair(children.get(i), depth+1));
        }
    }
}

private static void printWithSpaces(int depth, String label){
    // little bit optimized instead of printing spaces
    char[] chars = new char[3*depth];
    Arrays.fill(chars, ' ');
    StringBuilder sb = new StringBuilder();
    sb.append(chars).append(label);
    System.out.println(sb);
}

private static class Pair{
    NaryTreeNode node;
    int depth;

    public Pair(NaryTreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}