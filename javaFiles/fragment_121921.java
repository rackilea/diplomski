public void balance(){
    ArrayList<Integer> list= new ArrayList<Integer>();
    NewBST bst= new NewBST();
    infix(root, list);

    balRec(list, 0, list.size()-1,bst);
    root= bst.root;     
}