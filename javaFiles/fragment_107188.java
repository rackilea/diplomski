private static void addNodesRecursive(TreeNode node) {
    for(String stationName : network.getConnections(node)) {
        TreeNode child = new TreeNode(stationName);
        node.addChild(child);
        addNodesRecursive(child);
    }   
}