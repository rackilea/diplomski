// This is the start of your linked list
Node start = ...;

public void add(String s){
    // This may change depending on how you construct a node
    Node toAdd = new Node(s);
    // Iterate until we reach the end
    while(start.getNextNode() != null)
        start = start.getNextNode();
    start.setNextNode(toAdd);

}