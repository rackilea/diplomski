LambdaInference.java:16: Note: Deferred instantiation of method <T>foo(Bar<T>)
    Foo.foo(value -> true).booleanValue(); // Compile error here
           ^
  instantiated signature: (Bar<Object>)Object
  target-type: <none>
  where T is a type-variable:
    T extends Object declared in method <T>foo(Bar<T>)