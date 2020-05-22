...
Two.java:9: Note: Deferred instantiation of method <T>of(T)
        Stream.of(Optional.empty()).collect(Collectors.toList());
                 ^
  instantiated signature: (Optional<Object>)Stream<Optional<Object>>
  target-type: <none>
  where T is a type-variable:
    T extends Object declared in method <T>of(T)
Two.java:9: Note: resolving method collect in type Stream to candidate 0
        Stream.of(Optional.empty()).collect(Collectors.toList());
...