int getLongestPathLength(Node node) {
    if(node == null) return 0;
    int max = 0;
    for(Node child : node.children){
        max = Math.max(getLongestPathLength(child),max);
    }
    return 1+max;
}