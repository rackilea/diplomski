private static final String FILENAME = "TextFile.txt";
private static final int PART_SIZE = xxx; // HERE

public static void main(final String... args)
    throws IOException
{
    final Path file = Paths.get(FILENAME).toRealPath();
    final String filenameBase = file.getFileName().toString();
    final byte[] buf = new byte[PART_SIZE];    

    int partNumber = 0;
    Path part;
    int bytesRead;
    byte[] toWrite;

    try (
        final InputStream in = Files.newInputStream(file);
    ) {
        while ((bytesRead = in.read(buf)) != -1) {
            part = file.resolveSibling(filenameBase + ".part" + partNumber);
            toWrite = bytesRead == PART_SIZE ? buf : Arrays.copyOf(buf, bytesRead);
            Files.write(part, toWrite, StandardOpenOption.CREATE_NEW);
            partNumber++;
        }
    }
}