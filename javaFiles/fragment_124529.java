private TreeNode getDefaultNode(List list, String supervisingGroupName){
    TreeNode node = null;
    for (int i = 0; i < list.size(); i++){
        node = (TreeNode) list.get(i);
        OSGroup temp = (OSGroup) node.getNodeBusinessObject();

        if (supervisingGroupName.equals(temp.getName())){
            break;
        } else {
            node = getDefaultNode(tempNode.getChildren(), supervisingGroupName);
            if (node != null){
                break;
            }
        }

    }

    return node;
}