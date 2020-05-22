@Test
public void testFoo() {
  Foo foo = new Foo();
  ReflectionTestUtils.setField(foo, "id", 1L);
  // assertion
}