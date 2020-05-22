Stack<Node> fringe = new LinkedList<Node>();
fringe.push(root);

while(fringe.isEmpty() == false) {
  Node current = fringe.pop();

  // Evaluate the current move, e.g. if it leads to an improvement of your gameplay
  boolean result = doSomething(current); 

  if(result && !current.getChildren().isEmpty()) {
     for(Node child: current.getChildren()) {
        fringe.push(child);
     }
  }
}