ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
    CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();
    CharBuffer charBuffer = CharBuffer.allocate(bytes.length * 50);
    charBuffer.append("<html>");
    for (;;) {
        try {
            CoderResult result = decoder.decode(byteBuffer, charBuffer, false);
            if (!result.isError()) {
                break;
            }
        } catch (RuntimeException ex) {
        }
        int b = 0xFF & byteBuffer.get();
        charBuffer.append(String.format(
            "<span style='background-color:red; font-weight:bold'> %02X </span>",
            b));
        decoder.reset();
    }
    charBuffer.rewind();
    String t = charBuffer.toString();
    System.out.println("t: " + t);