public class Foo {
   void bar() {
     final int a;
     a = 10;
     a = 11; // Not legal, even in Java: a has already been assigned a value.
   }
}