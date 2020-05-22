class ComputeEngine {

  private static List<Foo> fooList;

  class Manipulator implements FooListManipulator {
    public void addFoo( Foo f ) {
      synchronized( fooList ) {
        fooList.add( f );
      }
    } 

    public List<Foo> getFooList() {
      return Collections.unmodifiableList( fooList );
    }
  }

  private Task createTask() {
    return new Task( new Manipulator() );  
  }
}