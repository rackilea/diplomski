private static void doReadFileNew(Path fileLocation) throws IOException, FileNotFoundException {
     final int READ_FILE_BUFFER_SIZE = Integer
                .valueOf(System.getProperty("READ_FILE_BUFFER_SIZE", "8192"));
    StringBuilder output = null;
    Charset charset = Charset.forName("UTF-8");
    try (RandomAccessFile raf = new RandomAccessFile(fileLocation.toFile(), "r");
            FileChannel fc = raf.getChannel();) {
            output = new StringBuilder(READ_FILE_BUFFER_SIZE);
            try {
                ByteBuffer buffer = ByteBuffer.allocate(READ_FILE_BUFFER_SIZE);
                while (fc.read(buffer) > 0) {
                    buffer.flip();
                    for (int i = 0; i < buffer.limit(); i++) {
                        output.append(charset.decode(buffer));
                    }
                    buffer.clear();
                }
            } finally { }
    } catch (Exception e) {
        throw e;
    }
    System.out.println(output);
}