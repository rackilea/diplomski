public void doSomething(Number param) {
  if( param instanceof Double) {
    System.out.println("param is a Double");
  }
  else if( param instanceof Integer) {
    System.out.println("param is an Integer");
  }

  if( param instanceof Comparable) {
    //subclasses of Number like Double etc. implement Comparable
    //other subclasses might not -> you could pass Number instances that don't implement that interface
    System.out.println("param is comparable"); 
  }
}