public static Node reconstructfromflattenBST(List<Integer> list){
    reconstruct(list, Integer.MAX_VALUE, true);
}

public static Node reconstruct(List<Integer> list, int priorData, boolean left){
    if (list.isEmpty()){
        return null;
    }
    int data = list.remove(0);
    if ((data <= priorData) != left) {
        return null;
    }
    Node root = new Node(data);
    root.left=reconstruct(list, data, true);
    root.right=reconstruct(list, data, false);

    return root;
}