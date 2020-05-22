static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
    IOException exception = null;
    BufferedReader br = new BufferedReader(new FileReader(path));
    try {
      return br.readLine();
    } catch (IOException e) {
      exception = e;
    } finally {
      try {
        if (br != null) br.close();
      } catch (IOException e) {
        // Both the original call and close failed. Eek!
        // Decide what you want to do here...
      }
      // close succeeded, but we already had an exception
      if (exception != null) {
        throw exception;
      }
    }
}