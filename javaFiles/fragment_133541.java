public class Foo<T extends Number> {
  T value; // you can declare fields of type T here

  int foo() {
    // Since you said T extends Number, you can call methods of Number on value
    return value.intValue(); 
  }
}