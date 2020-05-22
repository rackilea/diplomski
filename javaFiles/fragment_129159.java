interface FooListManipulator {
  void addFoo( Foo f );
  List<Foo> getFooList();
}

class Task {
  private FooListManipulator fooListManipulator;

  public Task( FooListManipulator fooListManipulator ) {
    this.fooListManipulator = fooListManipulator;
  }
}