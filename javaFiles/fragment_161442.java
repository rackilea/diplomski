int getNextAdjVertex(int currentVertex,int vertexICameFrom) {
  return the first vertex adjacent to currentVertex, bigger than vertexICameFrom
  or -1 if it does not exist
}

if (v == -1) {
  vertexList[lastVisited].wasVisited = false;
  System.out.println("Go back to: " + theStack.peek());
  //going down in the right direction:

  int backTo = theStack.peek();
  int newDestination = getNextAdjVertex(backTo,lastVisited);

  //now same as the else part, a step downward
  vertexList[newDestination].wasVisited = true;
  lastVisited = newDestination;
  System.out.println("Visited: " + newDestination);
  theStack.push(newDestination);
}