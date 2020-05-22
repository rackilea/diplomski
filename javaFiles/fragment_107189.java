private static void addNodesRecursive(TreeNode node, List<TreeNode> addedList) {
    for(String stationName : network.getConnections(node)) {
        TreeNode child = new TreeNode(stationName);
        node.addChild(child);
        addedList.add(child);
        addNodesRecursive(child, addedList);
    }   
}