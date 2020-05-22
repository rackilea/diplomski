public int getNumberOfChildNodes(int level) {
    if(level == 0)
        return childNodes.size();

    int numOfChildren = 0;
    for (Tree childNode : childNodes) {
        numOfChildren += childNode.getNumberOfChildNodes(level-1);
    }

    return numOfChildren ;
}