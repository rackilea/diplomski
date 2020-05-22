interface Handler {
  void handle( Object o );
  Class<?> getHandledClass();
}

class Test1Handler implements Handler() {
  public void handle( Object o ) {
    ((Test1)o).callSomeSpecificMethod();
  }

  public Class<?> getHandledClass() {
    return Test1.class;
  }      
}