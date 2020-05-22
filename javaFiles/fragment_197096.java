class Foo {
  Class<?> bar() throws NoSuchFieldException {
    class Bar<S> { }
    return Bar.class;
  }

  static void main(String[] args) throws NoSuchFieldException {
    System.out.println(new Foo<Void>().bar().getDeclaringClass()); // null
    System.out.println(new Foo<Void>().bar().getEnclosinglass()); // Foo
  }
}