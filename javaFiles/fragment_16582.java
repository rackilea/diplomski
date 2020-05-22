public static List<String> readAllLines(File file, Charset encoding)
      throws IOException {
    List<String> lines = new ArrayList<>();
    try (Scanner scanner = new Scanner(file, encoding.name())) {
      while (scanner.hasNextLine()) {
        lines.add(scanner.nextLine());
      }
      if (scanner.ioException() != null) {
        throw scanner.ioException();
      }
    }
    return lines;
  }