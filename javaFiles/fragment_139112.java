public static boolean removeRecursively(Map<String, List<Node>> tree, String id, Set<String> leavesToKeep) {
    List<Node> children = tree.get(id);
    if (children == null || children.isEmpty()) {
        if (!leavesToKeep.contains(id)) {
            tree.remove(id);
            return true;
        } else return false;
    }
    children.removeIf(n -> removeRecursively(tree, n.id, leavesToKeep));
    if (children.isEmpty()) {
        tree.remove(id);
        return true;
    } else return false;
}