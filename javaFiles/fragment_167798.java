// the first class, A<K>:
class A<K> {
  void f(K x) {}
}

// the second class, defining the method with generic type parameters
class Test {
  <T> void foo(A<T> a, T x) {
    a.f(x); // now it works!
  }
}

// a third class, that uses the above two:
class Main {
  public static void main(final String... args) {
    final Test test = new Test();
    final A<String> a = new A<>();
    test.foo(a, "bar");
  }
}