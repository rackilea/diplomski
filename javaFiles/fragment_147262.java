void findPath(Node secondChildNode, int desiredOutput){
    Node n = breadthFirstSearch(secondChildNode, desiredOutput);
    if(n == null)
        System.out.println("false");
    else{
        ArrayList<Node> list = new ArrayList<>();
        while(n != null){
            list.add(n);
            n = n.pNode;
        }
        for(int i = list.size() - 1; i >= 0; i--)
            System.out.println(list.get(i).value);
    }
}
Node breadthFirstSearch(Node secondChildNode, int desiredOutput){
    if(!secondChildNode.isPossible())
        return null;
    Queue<Node> q = new LinkedList<Node>();
    q.add(secondChildNode);
    Node t;
    while((t = q.poll()) != null){
        if(t.value == desiredOutput)
            return t;
        Node left = t.createLeftChild();
        if(left.isPossible(desiredOutput))
            q.add(left);
        Node right = t.createRightChild();
        if(right.isPossible(desiredOutput))
            q.add(right);
    }
    return null;
}