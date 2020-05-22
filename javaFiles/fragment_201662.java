C:\>type *.java
//Foo.java
package foo;
class Foo {
  String something( String s ) {
    return s + "!";
  }
}  
//Bar.java
package bar;
public interface Bar {
  public String something( String s );
}    
//Baz.java
package foo;    
import bar.Bar;    
public class Baz extends Foo implements Bar {
  // make sure you're overriding
  @Override
  public String something ( String s ) {
    return super.something( s );
  }
}     
//Use it: Main.java
package bar;
import foo.Baz;   
class Main {
  public static void main( String ... args ) {
    Bar bar = new Baz();
    System.out.println( bar.something("like this?"));
  }
}

C:\>java bar.Main
like this?!