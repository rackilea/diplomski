// local variable form
Foo foo = methodReturningFoo();
Bar bar = methodTakingFoo(foo);

// inlined form
Bar bar = methodTakingFoo(methodReturningFoo());