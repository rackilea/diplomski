private static int getLNDforMethod(DirectedNodeInterface curNode) {
    int max = 0;
    int own = isLoop(curNode) ? 1 : 0;
    NodeIterator successors = curNode.getSuccessors();
    while(successors.hasNext()) {
        successors.next();
        DirectedNodeInterface curSuc = (DirectedNodeInterface) successors.getNode();
        max = Math.max(max, own + getLNDforMethod(curSuc));
    }
    return max;
}