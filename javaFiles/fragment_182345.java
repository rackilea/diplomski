public static boolean allEqual(intBTNode root, int target)
{
    List<intBTNode> nodesToVisit = new ArrayList<intBTNode>();
    nodesToVisit.add(root);
    while (! nodesToVisit.isEmpty()) {
        intBTNode node = nodesToVisit.remove(nodesToVisit.size() - 1);
        if (node == null)
            continue;
        if (node.data != target)
            return false;
        nodesToVisit.add(node.left);
        nodesToVisit.add(node.right);
    }
    return true;
}