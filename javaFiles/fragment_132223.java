rootNode = new TreeNodeImpl<Item>();
for (some loop here) {
    TreeNode<Item> node = new TreeNodeImpl<Item>();
    Item item = ..; //get or create the item;
    node.setData(item);
    node.setParent(rootNode);
    rootNode.addChild("someIdentifier", node);
}