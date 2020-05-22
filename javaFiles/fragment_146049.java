LambdaInference.java:16: Note: resolving method foo in type Foo to candidate 0
    Foo.<Boolean> foo(value -> true).booleanValue(); // Compile error here
       ^
  phase: BASIC
  with actuals: <none>
  with type-args: Boolean
  candidates:
      #0 applicable method found: <T>foo(Bar<T>)
        (partially instantiated to: (Bar<Boolean>)Boolean)
  where T is a type-variable:
    T extends Object declared in method <T>foo(Bar<T>)
LambdaInference.java:16: Note: resolving method booleanValue in type Boolean to candidate 0
    Foo.<Boolean> foo(value -> true).booleanValue(); // Compile error here
                                    ^
  phase: BASIC
  with actuals: no arguments
  with type-args: no arguments
  candidates:
      #0 applicable method found: booleanValue()