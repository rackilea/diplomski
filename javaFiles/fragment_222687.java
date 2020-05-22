class Node {
    private String name;
    private List<Node> children;

    @Override
    public String toString() {
        String s = name;
        for(Node n: children) s += children.toStringWithIndent(1);
        return s;
    }

    private String toStringWithIndent(int depth) {
        // same as toString() but with indent
        String s = indentFor(depth) + name;
        for(Node n: children) s += indentFor(depth) +
                children.toStringWithDepth(depth + 1);
        return s;
    }

    private static String indentFor(int depth) {
        StringBuilder b = new StringBuilder(depth);

        while(depth-- > 0) {
            b.append(" ");
        }

        return b.toString();
    }


}