@Builder(toBuilder = true)
class Foo {
    // fields, etc
}

Foo foo = getReferenceToFooInstance();
Foo copy = foo.toBuilder().build();