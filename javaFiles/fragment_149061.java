public static class Info {
    private String id;
    private String[] parents;

    private String getID() {
        return id;
    }

    public String[] getParents() {
        return parents;
    }
}

public static class TreeNode extends GraphNode<Info> {
    public TreeNode(Info info) {
        super(info);
    }
}

private void insertGraph(Map<String, TreeNode> allNodes, List<Info> insertList) {
    for (Info info : insertList) {
        TreeNode newNode = new TreeNode(info);
        allNodes.put(info.getID(), newNode);
    }
    for (TreeNode node : allNodes.values()) {
        for (String parentID: node.getData().getParents()) {
            TreeNode parentNode = allNodes.get(parentID);
            parentNode.addOut(node);
        }
    }
}

private TreeNode scanTree(Info rootInfo, List<Info> insertList) {
    Map<String, TreeNode> allNodes = new HashMap<>();
    insertList.add(rootInfo);
    insertGraph(allNodes, insertList);
    return allNodes.get(rootInfo.getID());
}