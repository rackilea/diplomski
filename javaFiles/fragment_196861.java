%pragma(java) modulecode = %{
  private static byte[] buf2bytearr(java.nio.ByteBuffer buf) {
    try {
      return buf.array();
    }
    catch (UnsupportedOperationException e) {
      byte arr[] = new byte[buf.capacity()];
      buf.get(arr);
      return arr;
    }
  }
%}