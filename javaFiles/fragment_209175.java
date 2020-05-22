public static char[][] readChessFile(String filename) throws IOException {
  char[][] input = new char[8][8];
  try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {

    String line;
    for (int i = 0; i < input.length; i++) {
      line = bufferedReader.readLine();
      if (line == null || line.length() != 8) {
        throw new IllegalStateException("File is not in correct format");
      }
      input[i] = line.toCharArray();
    }
  }
  return input;
}