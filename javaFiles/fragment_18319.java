long start2 = System.nanoTime();
FileInputStream fis = new FileInputStream("/tmp/random.ints");
MappedByteBuffer buffer2 = fis.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, values * 4).order(ByteOrder.nativeOrder());
for (int i = 0; i < values; i++)
    buffer2.getInt();
fis.close();
long time2 = System.nanoTime() - start2;
System.out.printf("Took %.3f seconds to read %,d values%n", time2 / 1e9, values);