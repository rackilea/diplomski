Charset utf8 = Charset.forName("UTF-8");
CharsetEncoder encoder = utf8.newEncoder();
CharBuffer input = //allocate in some way, or pass as parameter
ByteBuffer output = ByteBuffer.allocate(10);

int limit = input.limit();
while(input.position() < limit) {
    output.clear();
    input.mark();
    input.limit(Math.max(input.position() + 2, input.capacity()));
    if (Character.isHighSurrogate(input.get()) && !Character.isLowSurrogate(input.get())) {
        //Malformed surrogate pair; do something!
    }
    input.limit(input.position());
    input.reset();
    encoder.encode(input, output, false);
    int encodedLen = output.position();
}