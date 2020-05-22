byte[] bytes = new byte[10];
ByteBuffer bbuf = ByteBuffer.wrap(bytes);
CharBuffer cbuf = bbuf.asCharBuffer();
cbuf.put("t");
FileOutputStream test = new FileOutputStream("somebytes");
test.write(bytes);
test.close();