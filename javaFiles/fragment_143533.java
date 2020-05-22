private static final char [] subset = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

char buf[] = new char[length];
for (int i=0;i<buf.length;i++) {
  int index = r.nextInt(subset.length);
  buf[i] = subset[index];
}

return new String(buf);