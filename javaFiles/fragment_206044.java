class Node {
    public int value;
    public List<Node> children = new ArrayList<>();
    public Node parent; // Unused?

    public Node bestChild() {
        // Modern, easy approach:
        return children
               .stream()
               .max((x, y) -> Integer.compare(x.value, y.value))
               .get();

        // Old, classic Java approach:
        /*
        int max = Integer.MIN_VALUE;
        Node maxNode = null;

        for (Node child : this.children) {
            if (max < child.value) {
                max = child.value;
                maxNode = child;
             }
        }

        return maxNode; */
    }
}