FileInputStream input = new FileInputStream("C:/logs.txt");
FileChannel channel = input.getChannel();
byte[] buffer = new byte[256 * 1024];
ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);

try {
    for (int length = 0; (length = channel.read(byteBuffer)) != -1;) {
        System.out.write(buffer, 0, length);
        byteBuffer.clear();
    }
} finally {
    input.close();
}