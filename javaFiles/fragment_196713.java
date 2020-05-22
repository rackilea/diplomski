public int printTreeInOrder(Node node, int k){
    //in-order printing (sorted)
    if (k>0 && !(isNull(node))){
        k = printTreeInOrder(node.getLeft(),k);
        if (k>0) {
            System.out.println(node.getValue());
            k--;
        }
        return printTreeInOrder(node.getRight(),k);
    }
    return k;
}