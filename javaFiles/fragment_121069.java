List<Integer> treeValues = new ArrayList<Integer>();

List<Integer> treeToList(Node node){
    if (node == null) 
        return; 
    printInorder(node.left); 
    if(!node.isEmpty){
        treeValues.add(node.value); 
    }
    printInorder(node.right); 
}

void sortedTree(Node node){
    List<Integer> treeData = treeToList(node);
    Collections.sort(treeData);
    for(int i=0; i<treeData.size();i++ ){
        System.out.println(treeData.get(i));
    }
}