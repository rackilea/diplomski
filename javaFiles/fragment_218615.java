import groovy.lang.Closure ;

public class Example extends Closure {
  public Example( Object owner, Object thisObject ) {
    super( owner, thisObject ) ;
  }

  public Example( Object owner ) {
    super( owner ) ;
  }

  public Object call( Object params ) {
    System.out.println( "EX: " + params ) ;
    return params ;
  }
}