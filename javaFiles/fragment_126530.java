private boolean trace(Node parent, Node node){
    mainStack.push(parent);
    if(node.data == parent.data){
        for(Node iNode:mainStack){
            System.out.println(iNode.data);
        }
        return true;
    }
    if(parent.left != null){
        if (trace(parent.left, node)) return true;
    }
    if(parent.right!=null){
        if (trace(parent.right, node)) return true;
    }
    mainStack.pop();
    return false;
}