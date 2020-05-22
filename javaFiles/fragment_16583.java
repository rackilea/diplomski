public static List<String> readAllLinesSloppy(File file, Charset encoding)
      throws IOException {
    List<String> lines = new ArrayList<>();
    try (InputStream in = new FileInputStream(file);
        Reader reader = new InputStreamReader(in, encoding);
        Scanner scanner = new Scanner(reader)) {
      while (scanner.hasNextLine()) {
        lines.add(scanner.nextLine());
      }
      if (scanner.ioException() != null) {
        throw scanner.ioException();
      }
    }
    return lines;
  }