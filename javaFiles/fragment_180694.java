ByteBuffer buf = ByteBuffer.allocate(512);

try (RandomAccessFile raf = new RandomAccessFile("\\\\.\\PhysicalDrive0", "r");
     FileChannel fc = raf.getChannel()) {
    fc.read(buf);
    System.out.println("It worked! Read bytes: " + buf.position());
} catch (Exception e) {
    e.printStackTrace();
}