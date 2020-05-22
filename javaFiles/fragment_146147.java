BST bst = new BST();
//test insertion of 100 items
for ( int i = 0; i < 100; i++ ){
    bst.insert(String.valueOf(i));
    if ( bst.size() != i+1 ){
        throw new Exception("Invalid BST size " + bst.size());
    }
}