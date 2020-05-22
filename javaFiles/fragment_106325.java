ByteBuffer wrap = ByteBuffer.allocate(1024);
ByteBufferBytes bufferBytes = new ByteBufferBytes(wrap);
byte[] bytes = "BAC,12.32,12.54,12.56,232443".getBytes();

int runs = 10000000;
long start = System.nanoTime();
for (int i = 0; i < runs; i++) {
    bufferBytes.reset();
    // read the next message.
    bufferBytes.write(bytes);
    bufferBytes.position(0);
    // decode message
    String word = bufferBytes.parseUTF(StopCharTesters.COMMA_STOP);
    double low = bufferBytes.parseDouble();
    double curr = bufferBytes.parseDouble();
    double high = bufferBytes.parseDouble();
    long sequence = bufferBytes.parseLong();
    if (i == 0) {
        assertEquals("BAC", word);
        assertEquals(12.32, low, 0.0);
        assertEquals(12.54, curr, 0.0);
        assertEquals(12.56, high, 0.0);
        assertEquals(232443, sequence);
    }
}
long time = System.nanoTime() - start;
System.out.println("Average time was " + time / runs + " nano-seconds");