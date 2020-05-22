public int processReader(BufferedReader r) throws IOException {
  String line;
  StringBuilder qsb = new StringBuilder();

  while ((line = r.readLine()) != null) {
    // Skipping through comments
    if (! line.startsWith("--")) {
      qsb.append(line + "\n");
    }
  }

  return (processLine(qsb.toString()));
}