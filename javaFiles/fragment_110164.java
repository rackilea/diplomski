error: method max2 in class Generics cannot be applied to given types;
    max2(Arrays.asList(new A()));
    ^
required: Collection<? extends T>
found: List<A>
reason: inference variable T has incompatible bounds
  equality constraints: Object
  upper bounds: Comparable<T>
where T is a type-variable:
  T extends Comparable<T> declared in method <T>max2(Collection<? extends T>)