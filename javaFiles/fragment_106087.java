abstract class Foo<T> {
   // or Foo<T extends Foo<T>>
   public abstract boolean testSth(T obj );
}

class Bar extends Foo<Bar> {
    @Override
     public boolean testSth( Bar obj ) { // I need the parameter to be of type Bar
       // ...
    }
 }