long heap = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
RandomAccessFile raf = new RandomAccessFile("array.dat", "rw");
IntBuffer map = raf.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 1 << 30).order(ByteOrder.nativeOrder()).asIntBuffer();
for (int i = 0; i < map.capacity(); i++)
    map.put(i, i);
long heap2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
System.out.printf("Wrote %,d int values, heap used %,d bytes approx%n", map.capacity(), heap2 - heap);