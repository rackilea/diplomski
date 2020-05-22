CharsetEncoder encoder = StandardCharsets.UTF_8.newEncoder();

String text = "java.abcded.tocken";
CharBuffer cb = CharBuffer.wrap(text.toCharArray());
ByteBuffer bb = encoder.encode(cb);
System.out.println(bb.remaining());
System.out.println(bb.array().length);