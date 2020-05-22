@Test
public void testMyClassConstruction() throws Exception {
  MyClass myClass = new MyClass() {
    public int size() {
      return items.size();
    }
  }

  assertEquals(2, myClass.size());
}