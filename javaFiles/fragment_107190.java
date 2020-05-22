private static void addNodesRecursive(TreeNode node, List<String> addedList) {
    for(String stationName : network.getConnections(node)) {
        if (!addedList.contains(stationName)) {
            TreeNode child = new TreeNode(stationName);
            node.addChild(child);
            addedList.add(child);
            addNodesRecursive(child, addedList);
        }
    }   
}