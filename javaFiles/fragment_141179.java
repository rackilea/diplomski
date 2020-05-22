private void initializeTree(List tree) { 

 do{

    TreeNode left = tree.remove(0);
    TreeNode right = tree.remove(0);

    tree.add(new TreeNode((byte)0, left.getFreq() + right.getFreq(), left, right));

    Collections.sort(tree);

}while(tree.size() > 1);

root = tree.get(0);
printTree(System.out);