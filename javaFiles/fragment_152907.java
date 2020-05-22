class Foo<T> {
   public void method1( T arg1 ) { ... }
}

class Bar extends Foo<Baz> { ... }

Foo<?> foo = new Foo<Baz>();
Bar bar = new Bar();