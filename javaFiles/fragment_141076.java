static void merge(Node a, Node b){
    List<Node> toMerge = new ArrayList<>(a.getChildren()).retainAll(b.getChildren());
    List<Node> toAdd = new ArrayList<>(b.getChildren()).removeAll(a.getChildren());

    for(Node n : toMerge)
        merge(n, b.getChildren().get(b.getChildren().indexOf(n)));

    for(Node n : toAdd)
        a.addChild(n.deepCopy());
}

class Node{
    ... //variables, constructor, equals, etc.

    public Node deepCopy(){
        Node n = new Node(data);

        for(Node c : children)
            n.addChild(c.deepCopy());

        return n;
    }
}