public void unmapMmaped(ByteBuffer buffer) {
  if (buffer instanceof sun.nio.ch.DirectBuffer) {
    sun.misc.Cleaner cleaner = ((sun.nio.ch.DirectBuffer) buffer).cleaner();
    cleaner.clean();
  }
}