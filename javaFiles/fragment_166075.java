private static final String READ_WRITE = "rw";
private static final Random random = new Random();

public static void scramble(String filePath, int scrambledByteCount) throws IOException{
    RandomAccessFile file = new RandomAccessFile(filePath, READ_WRITE);

    long fileLength = file.getLength();
    for(int count = 0; count < scrambledByteCount; count++) {
        long nextPosition = random.nextLong(fileLength-1);
        file.seek(nextPosition);

        int scrambleByte = random.nextInt(255) - 128;
        file.write(scrambleByte);
    }

    file.close();
}