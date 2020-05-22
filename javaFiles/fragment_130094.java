@Test
public void test() throws Exception {

  Foo foo = mock(Foo.class);

  Set<String> set = new HashSet<>();
  set.add("a");
  set.add("b");

  foo.doSomething(set);

  Set<String> set2 = new HashSet<>();
  set2.add("b");
  set2.add("a");

  verify(foo).doSomething(set2);
}

public interface Foo {
  void doSomething(Set<String> strings);
}