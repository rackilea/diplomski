$ javac -XDverboseResolution=deferred-inference,success,applicable LambdaInference.java 
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
LambdaInference.java:16: Note: Deferred instantiation of method <T>foo(Bar<T>)
    Foo.foo(value -> true).booleanValue(); // Compile error here
           ^
  instantiated signature: (Bar<Object>)Object
  target-type: <none>
  where T is a type-variable:
    T extends Object declared in method <T>foo(Bar<T>)
LambdaInference.java:16: error: cannot find symbol
    Foo.foo(value -> true).booleanValue(); // Compile error here
                          ^
  symbol:   method booleanValue()
  location: class Object
1 error