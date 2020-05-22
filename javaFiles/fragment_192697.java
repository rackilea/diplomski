final class Three {
  void three() {
    List<Optional<Integer>> optionalList1 =
        Stream.of(Optional.<Integer>empty()).collect(Collectors.toList());
  }
}

...
Three.java:9: Note: resolving method of in type Stream to candidate 1
        Stream.of(Optional.<Integer>empty()).collect(Collectors.toList());
              ^
  phase: BASIC
  with actuals: Optional<Integer>
  with type-args: no arguments
  candidates:
      #0 not applicable method found: <T#1>of(T#1...)
        (cannot infer type-variable(s) T#1
          (argument mismatch; Optional<Integer> cannot be converted to T#1[]))
      #1 applicable method found: <T#2>of(T#2)
        (partially instantiated to: (Optional<Integer>)Stream<Optional<Integer>>)
  where T#1,T#2 are type-variables:
    T#1 extends Object declared in method <T#1>of(T#1...)
    T#2 extends Object declared in method <T#2>of(T#2)
Three.java:9: Note: Deferred instantiation of method <T>of(T)
        Stream.of(Optional.<Integer>empty()).collect(Collectors.toList());
                 ^
  instantiated signature: (Optional<Integer>)Stream<Optional<Integer>>
  target-type: <none>
  where T is a type-variable:
    T extends Object declared in method <T>of(T)
...