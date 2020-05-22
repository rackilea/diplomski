package so3898131;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChunkTest {

  /** Ensure that the simplest possible case works as expected. */
  @Test
  public void testEmptySplit() {
    Chunk<Object> old = new Chunk<Object>();
    Chunk<Object> split = old.split(old);
    assertEquals(0, split.chunkSize);
    assertEquals(0, split.items.length);
    assertEquals(0, split.index);
    assertEquals(1, old.index);
  }

  @Test
  public void testSplitWithOneItem() {
    // TODO: make sure that after splitting one of the chunks contains
    // one element, the other none.
  }

  @Test
  public void testSplitWithTwoItems() {
    // TODO: make sure that after splitting a chunk with two elements
    // each of the new chunks contains exactly one of the elements.
    // Use assertSame(..., ...) to check it.
  }
}