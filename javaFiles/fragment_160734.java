@Test
public void testSplitLinkage() {
  Chunk<Object> old = new Chunk<Object>();
  assertNull(old.prev);
  assertNull(old.next);

  Chunk<Object> split = old.split(old);

  assertNull(old.prev);
  assertSame(split, old.next);
  assertSame(old, split.prev);
  assertNull(split.next);
}