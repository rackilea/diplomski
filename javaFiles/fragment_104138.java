Error:(27, 41) java: method getCollectionIntializer in class SomeClass cannot be applied to given types;
  required: java.lang.Class<T>
  found: java.lang.Class<capture#1 of ? extends SomeClass>
  reason: inferred type does not conform to upper bound(s)
    inferred: capture#1 of ? extends SomeClass
    upper bound(s): java.lang.Number