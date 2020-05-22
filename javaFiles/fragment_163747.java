byte[] buf = new byte[3200000];
int pos = 0;
while (pos < buf.length) {
  int n = in.read(buf, pos, buf.length - pos);
  if (n < 0)
    break;
  pos += n;
}
ByteBuffer buff = ByteBuffer.wrap(buf, 0, pos);