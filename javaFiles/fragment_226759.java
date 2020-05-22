@Test
public void testBinaryHeapDefault() throws Overflow{
      BinaryHeap bh1 = new BinaryHeap( 5 );
      assertEquals(false, bh1.isFull( ));
      bh1.insert( 2 );
}