class A {
  public A() {
    this( false );
  }

  public A(boolean someFlag) {
  }
}

class B extends A {
  public B() {
    super();
  }

  public B( boolean someFlag ) {
    super( someFlag );
  }

  public B ( int someNumber ) {
    this(); //
  }
}