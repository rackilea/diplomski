public Node insert(int value,Node n){
    if(n==null){
        return new Node(value);
    }else{
        if(value<n.getKey()){
            Node newNode = insert(value,n.getLeft());
            if(n.getLeft()==null){
              n.setLeft(newNode);
            }
            return newNode;
        }else if (value>n.getKey()){
            Node newNode = insert(value,n.getRight());
            if(n.getRight()==null){
              n.setRight(newNode);
            }
            return newNode;
        }else{
            System.out.println("duplicate");
            return null;
        }
    }
}