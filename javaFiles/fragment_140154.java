public class Foo {
  public static void main( String[] args ) {
    double nan1 = 0.0 / 0.0;        Double box1 = nan1;
    double nan2 = Math.sqrt(-1);    Double box2 = nan2;
    System.out.println( nan1 == nan2 );         // false, as expected
    System.out.println( box1.equals(box2) );    // true -- WTF???
  }
}