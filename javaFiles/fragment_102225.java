class Store{
  final LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>();

  void add(final Object o){
    queue.put(o); // blocks until there is free space in the optionally bounded queue
  }

  void processAndClear(){
    Object element;
    while ((element = queue.poll()) != null) { // does not block on empty list but returns null instead
      doSomething(element);
    }
  }
}