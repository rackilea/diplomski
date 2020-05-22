Charset utf8 = Charset.forName("UTF-8");
CharsetEncoder encoder = utf8.newEncoder();
char[] array = new char[1];
CharBuffer input = CharBuffer.wrap(array);
ByteBuffer output = ByteBuffer.allocate(10);
for (int reps = 0; reps < 10000; reps++) {
    for (array[0] = 0; array[0] < 10000; array[0]++) {
        output.clear();
        input.clear();
        encoder.encode(input, output, false);
        int len = output.position();
    }
}