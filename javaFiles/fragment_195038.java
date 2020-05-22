Iterator<TreeLayoutNode> it = children.iterator();
while(it.hasNext()){
    TreeLayoutNode child = it.next();
    if(nodeMap.containsKey(child.getName())){
        TreeLayoutNode duplicate = nodeMap.get(child.getName());
        List<TreeLayoutNode> childrenOfChild = child.getChildren();
        if(CollectionUtils.isNotEmpty(childrenOfChild)){
            for(TreeLayoutNode single: childrenOfChild){
                duplicate.addChildNode(single);
            }
            node.removeChildNode(child);
            mergeNode(duplicate, nodeMap);
        }
    }else{
        nodeMap.put(child.getName(), child);
    }
}