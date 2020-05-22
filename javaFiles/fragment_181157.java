final Path src = Paths.get("/path/to/original/file.txt")
final Path dst = Paths.get("/path/to/destination/file.txt");

final char[] buf = new char[1 << 20]; // 1 MB char buffer
int nrChars;

try (
    final BufferedReader reader = Files.newBufferedReader(src, 
        Charset.forName("windows-1252"));
    final BufferedWriter writer = Files.newBufferedWriter(dst,
        StandardCharsets.UTF_16LE, StandardOpenOption.CREATE);
) {
    while ((nrChars = reader.read(buf, 0, buf.length)) != -1)
        writer.write(buf, 0, nrChars);
    writer.flush();
}