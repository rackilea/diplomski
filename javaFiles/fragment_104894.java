void printGraph() {
    System.out.println(graph.keySet().iterator().next().value);
    // use the non-raw type here
    Iterator<Node<T>> itKey = graph.keySet().iterator();
    System.out.println(itKey.next());
    System.out.println(itKey.next().value); 
    while (itKey.hasNext()) {
      // code
    }
  }