boolean ok = false;
try {
  int b = in.read();
  ok = b >= 0;
  if (!ok)
     throw new EOFException();
} finally {
  if (!ok)
     in.close();
}