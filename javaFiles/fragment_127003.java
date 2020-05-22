final Path file = Paths.get(filename);
String line;
String[] incoming;
String[] results = new String[101];
int nrElements = 0;

try (
    final BufferedReader reader = Files.newBufferedReader(path,
        StandardCharsets.UTF_8);
) {
    while ((line = reader.readLine()) != null) {
        incoming = line.split(",");
        if (incoming.length != 2)
            continue;
        results[nrElements++] = incoming[0];
        results[nrElements++] = incoming[1];
    }
}

return Arrays.copyOfRange(results, 0, nrElements);