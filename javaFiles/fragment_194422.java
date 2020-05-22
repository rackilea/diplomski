public int getDeepestNode(AvlNode head) {
    return getDeepestNodeSafe(head, new ArrayList<AvlNode>());
}

public int getDeepestNodeSafe(AvlNode head, List<AvlNode> pathFromRoot) {
    if (head == null) {
        return 0;
    } else {
        if (pathFromRoot.contains(head)) {
            StringBuilder sb = new StringBuilder("Cycle: ");
            for (AvlNode node : pathFromRoot) {
                if (node == head) {
                   sb.append("***");
                }
                sb.append(node).append("; ");
            }
            Logger.getLogger(getClass().getName()).log(Level.WARN, sb.toString());
            return 0;
        }
        pathFromRoot.add(head);
        int depth = Math.max(getDeepestNodeSafe(head.left, pathFromRoot),
                             getDeepestNodeSafe(head.right), pathFromRoot) + 1;
        pathFromRoot.remove(pathFromRoot.size() - 1); // Undo
        return depth;
    }
}