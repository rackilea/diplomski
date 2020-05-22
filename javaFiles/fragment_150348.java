LinkedList<Node> frontier = new LinkedList<>();

//assuming you always have a root node just add it
frontier.add( root );

Node goal = null;

//loop until the list is empty, if we found a goal node we'll break the loop from the inside
while( !frontier.isEmpty() ) {
  //get the node at the start of the list and remove it
  //in the first iteration this will be the root node
  Node node = frontier.pop();

  //found a goal so we're done
  if( node.isGoal ) {
    goal = node ;        
    break; //this breaks the while loop
  }

  //didn't find a goal yet so add the children at the end
  if( node.children != null ) {
    frontier.addAll( node.children );
  }
}