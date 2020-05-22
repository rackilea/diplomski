public Node add(Node n, int item){
    if (n==null){
        n=new Node(item);
    }
    else{
        if (n<root.item){
            n.izq=add(n.left,item);
        }
        else{
            n.right=add(n.right,item);
        }
    }
    return n;
}