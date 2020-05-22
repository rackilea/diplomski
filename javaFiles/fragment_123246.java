class Node{
    final int id;
    int value;
    Node parent;
    public Node(int id, int value){
        super(id, value, null);
    }
    public Node(int id, int value, Node parent){
        this.id = id;
        this.value=value;
        this.parent=parent;
    }
}