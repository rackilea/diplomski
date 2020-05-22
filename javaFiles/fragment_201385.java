public class LenCounterTest {
  @Test public void testUtf8Len() {
    Charset utf8 = Charset.forName("UTF-8");
    AllCodepointsIterator iterator = new AllCodepointsIterator();
    while (iterator.hasNext()) {
      String test = new String(Character.toChars(iterator.next()));
      Assert.assertEquals(test.getBytes(utf8).length,
                          Utf8LenCounter.length(test));
    }
  }

  private static class AllCodepointsIterator {
    private static final int MAX = 0x10FFFF; //see http://unicode.org/glossary/
    private static final int SURROGATE_FIRST = 0xD800;
    private static final int SURROGATE_LAST = 0xDFFF;
    private int codepoint = 0;
    public boolean hasNext() { return codepoint < MAX; }
    public int next() {
      int ret = codepoint;
      codepoint = next(codepoint);
      return ret;
    }
    private int next(int codepoint) {
      while (codepoint++ < MAX) {
        if (codepoint == SURROGATE_FIRST) { codepoint = SURROGATE_LAST + 1; }
        if (!Character.isDefined(codepoint)) { continue; }
        return codepoint;
      }
      return MAX;
    }
  }
}