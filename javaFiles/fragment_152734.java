private void printAllNodeGreaterMyFoundNode(BSTnode p, int data){
    if(p == null){
        //do nothing reached the end
        return;
    }
    else{
        if(p.getData() >= data){
            System.out.println(p.getData());
        }
        printAllNodeGreaterMyFoundNode(p.getLeft(), data);
        printAllNodeGreaterMyFoundNode(p.getRight(), data);
    }
}