class Foo<T> {
  void a1(Object o) {
    // forces to be explicit about the chance of heap polution
    @SuppressWarning("unchecked")
    Set<String> a = (Set<String>) getField1(o, Set.class, "foo");
    T c = (T) getField1(o, Set.class, "foo"); // guaranteed not to compile
  }

  void a2(Object o) {
    // implicit chance of heap polution in case of Set<Date>
    Set<String> a = (Set<String>) getField2(o, "foo");
    T c = getField2(o, "foo"); // will succeed even if foo is Date
  }
}