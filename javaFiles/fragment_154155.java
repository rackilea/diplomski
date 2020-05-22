public int size(Node n) {
    Stack<Node> sizeStack = new Stack();
    int count = 1;//includes the n node
    if(n == null) {
        return 0;
    }
    sizeStack.push(n);
    while(!sizeStack.isEmpty()){
        node = sizeStack.pop();
        while(node != null) {
            count++;
            if(node.right != null){
                sizeStack.push(node.right);
            }
            node = node.left;
        }
    }
    return count;
}