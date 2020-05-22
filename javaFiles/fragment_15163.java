private Node insert(Node x, int key) {
    if (x==null){
        return new Node(key);
    }
    if (key > x.key) {
        x.right = insert(x.right, key);
    }else if (key < x.key) {
        x.left = insert(x.left, key);
    }else{
        x.key = key;
    }
    return x;
}