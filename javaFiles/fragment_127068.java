public static void main(String[] args) {
  //String str = "aaaaaaaaa";
  String str = "aaaaaaaaaa";
  Charset cs1 = Charset.forName("ASCII");
  Charset cs2 = Charset.forName("utf8");

  System.out.println(toHex(cs1.encode(str)));
  System.out.println(toHex(cs2.encode(str)));
}

public static String toHex(ByteBuffer buff) {
  StringBuilder builder = new StringBuilder();
  while (buff.remaining() > 0) {
    builder.append(String.format("%02x", buff.get()));
  }
  return builder.toString();
}