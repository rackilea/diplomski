private static void createTree(String homeStation) {
    root = new TreeNode(homeStation);
    List<String> addedList = new ArrayList<String>();
    addedList.add(homeStation);
    addNodesRecursive(root, addedList);
}