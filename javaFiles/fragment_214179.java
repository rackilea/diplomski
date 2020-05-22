ArrayList<MutableTreeNode> queue = new ArrayList<MutableTreeNode>();
queue.add(rootNode)
while(queue.size() > 0){
    MutableTreeNode tempNode = queue.get(0);//access first element only
    updatenumbers(tempNode);  //update children of just this single node
    queue.remove(0);//remove from queue

    //now add the children of tempNode
    queue.add(tempNode.left);
    queue.add(tempNode.right);
}