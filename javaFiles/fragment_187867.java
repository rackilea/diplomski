class BTreeNode {
    private int value;
    private List<BTreeNode> children;

    public int sumAtDepth(int depth) {
        if (depth == 0)
            return value;
        else if (depth > 0)
            return children.stream()
                .mapToInt(c -> c.sumAtDepth(depth - 1)).sum();
        else
            throw new IllegalArgumentException("Negative depth");
    }
}