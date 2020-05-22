LambdaInference.java:16: Note: resolving method foo in type Foo to candidate 0
    Boolean b = Foo.foo(value -> true);
                   ^
  phase: BASIC
  with actuals: <none>
  with type-args: no arguments
  candidates:
      #0 applicable method found: <T>foo(Bar<T>)
        (partially instantiated to: (Bar<Object>)Object)
  where T is a type-variable:
    T extends Object declared in method <T>foo(Bar<T>)
LambdaInference.java:16: Note: Deferred instantiation of method <T>foo(Bar<T>)
    Boolean b = Foo.foo(value -> true);
                       ^
  instantiated signature: (Bar<Boolean>)Boolean
  target-type: Boolean
  where T is a type-variable:
    T extends Object declared in method <T>foo(Bar<T>)