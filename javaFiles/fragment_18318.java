int values = 1000000;
ByteBuffer buffer = ByteBuffer.allocateDirect(4 * values).order(ByteOrder.nativeOrder());

Random random = new Random(1);
long start = System.nanoTime();
for (int i = 0; i < values; i++)
    buffer.putInt(random.nextInt());
buffer.flip();
FileOutputStream fos = new FileOutputStream("/tmp/random.ints");
fos.getChannel().write(buffer);
fos.close();
long time = System.nanoTime() - start;
System.out.printf("Took %.3f seconds to generate&write %,d values%n", time / 1e9, values);