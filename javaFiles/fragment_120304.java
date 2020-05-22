BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset));
try {
    String line;
    while ((line = reader.readLine()) != null) {
        processLine(line);
    }
} finally {
    reader.close();
}