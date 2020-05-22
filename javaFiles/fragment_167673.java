public boolean member(Node root, Integer val){
    Node currentNode = root;//keep track of current node
    while(currentNode != null){
        //switched currentNode.val and val to avoid null pointer exceptions
        if(val.equals(currentNode.val)){
        //if you're looking for nulls...still with the original
        //if(currentNode.val.equals(val)){
            System.out.println("true");
            return true;
        }
        currentNode = currentNode.next();//update current node
    }
    return false;
}