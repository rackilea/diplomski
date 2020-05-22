public Integer findMax(){
    Node<Integer,Integer> result = (Node<Integer,Integer>)root;
    result = findMax((Node<Integer, Integer>) root,result);
    return result.key;
}

private Node<Integer,Integer> findMax(Node<Integer,Integer> node,Node<Integer,Integer> result){
    if (node == null){
        return result;
    }
    if (node.value > result.value || 
            (node.value == result.value && node.key.compareTo(result.key) < 0)){
        result = node;
    }
    result = findMax(node.left,result);
    result = findMax(node.right,result);
    return result;
}