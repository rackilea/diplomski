public static void gather() {
    ByteBuffer header = ByteBuffer.allocate(10);
    ByteBuffer body = ByteBuffer.allocate(10);

    byte[] b1 = { '0', '1' };
    byte[] b2 = { '2', '3' };
    header.put(b1);
    body.put(b2);

    //flip buffers before writing them out.
    header.flip();
    body.flip();
    ByteBuffer[] buffs = { header, body };

    try(FileOutputStream os = new  FileOutputStream("d:/scattingAndGather.txt");
 FileChannel channel = os.getChannel()) {
    channel.write(buffs);
    } catch (IOException e) {
        e.printStackTrace();
    }
}