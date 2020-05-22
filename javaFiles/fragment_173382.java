// This is the start of your linked list
Node start = ...;

public void remove(String s){
    // Iterate until we find the node who's next one is the one to delete
    // We're assuming toString() returns the name of the student
    while(start.getNextNode().toString() != s)
        start = start.getNextNode();
    // Set our next node to the one 2 nodes down the line, thus skipping it
    start.setNextNode(start.getNextNode().getNextNode())

}