@Builder(toBuilder=true)
class Foo {
   int x;
   ...
}

Foo f0 = Foo.builder().build();
Foo f1 = f0.toBuilder().x(42).build();