while(fringe.isEmpty() == false) {
  Node current = fringe.poll();

  // Evaluate the current move, e.g. if it leads to an improvement of your gameplay
  boolean result = doSomething(current); 

  if(result && !current.getChildren().isEmpty()) {
     fringe.addAll(current.getChildren();
  }
}