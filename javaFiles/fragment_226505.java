StringBuilder sb = new StringBuilder("00000000");
for (int bit = 0; bit < 8; bit++) {
  if (((b >> bit) & 1) > 0) {
    sb.setCharAt(7 - bit, '1');
  }
}
System.out.println(sb.toString());