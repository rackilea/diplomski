@Test
public void test() {
  SwapListImpl<String> list = new SwapListImpl<String>();
  list.add("A");
  list.add("B");
  list.add("C");

  list.swap("A", "C");

  assertEquals("C", list.get(0));
  assertEquals("C", list.getHead().val);
  assertEquals("B", list.get(1));
  assertEquals("A", list.get(2));
  assertEquals("A", list.getTail().val);

  list.add("D");

  assertEquals("C", list.get(0));
  assertEquals("C", list.getHead().val);
  assertEquals("B", list.get(1));
  assertEquals("A", list.get(2));
  assertEquals("D", list.get(3));
  assertEquals("D", list.getTail().val);

  list.swap("A", "C");

  assertEquals("A", list.get(0));
  assertEquals("A", list.getHead().val);
  assertEquals("B", list.get(1));
  assertEquals("C", list.get(2));
  assertEquals("D", list.get(3));
  assertEquals("D", list.getTail().val);

  list.swap("C", "B");

  assertEquals("A", list.get(0));
  assertEquals("A", list.getHead().val);
  assertEquals("C", list.get(1));
  assertEquals("B", list.get(2));
  assertEquals("D", list.get(3));
  assertEquals("D", list.getTail().val);
}