class Store{
  final LinkedList<Object> queue = new LinkedList<>(); // has to be final for synchronized to work

  void add(final Object o){
    synchronized(queue) { // on the queue as this is the shared object in question
      queue.add(o);
    }
  }

  void processAndClear() {
    final LinkedList<Object> elements = new LinkedList<>(); // temporary local list
    synchronized(queue) { // here as well, as every access needs to be properly synchronized
      elements.addAll(queue);
      queue.clear();
    }

    for (Object e : elements) { 
      doSomething(e); // this is thread-safe as only this thread can access these now local elements
    }
  }
}