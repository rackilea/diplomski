interface Fooable {
   void someCommonMethod();
}

interface FooableEnum extends Fooable {
   int ordinal();
}

enum E1 implements FooableEnum {
   // Implement someCommonMethod.
   // ordinal() is already implemented by default.
}