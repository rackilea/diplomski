LambdaInference.java:16: Note: resolving method foo in type Foo to candidate 0
    Foo.foo(value -> true).booleanValue(); // Compile error here
       ^
  phase: BASIC
  with actuals: <none>
  with type-args: no arguments
  candidates:
      #0 applicable method found: <T>foo(Bar<T>)
        (partially instantiated to: (Bar<Object>)Object)
  where T is a type-variable:
    T extends Object declared in method <T>foo(Bar<T>)