public void insert(int x) {
    if(tree == null)
        tree = new NODE(x);
    else
        tree.insert(x);
}