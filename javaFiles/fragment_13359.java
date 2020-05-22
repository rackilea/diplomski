DefaultMutableTreeNode universeTitleNode = categoryToNode.get(e.getValue());
if (universeTitleNode == null ){
    universeTitleNode = new DefaultMutableTreeNode(e.getValue());
    categoryToNode.put(e.getValue(), universeTitleNode);
    genreMainTree.add(universeTitleNode);
}
mediaTitleNode = new DefaultMutableTreeNode(e.getKey());
universeTitleNode.add(mediaTitleNode);