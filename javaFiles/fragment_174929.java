int pos = 0;
while (true) {
  int count = is.read(buf, pos, buf.length - pos);
  if (count <= 0) {
    break;
  }
  pos += count;
}