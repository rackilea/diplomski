public static void mergeProductCodesToFile(String prefixFile, String inlineFile, String suffixFile, String productFile) throws IOException {
    try (BufferedReader prefixReader = new BufferedReader(new FileReader(prefixFile));
        BufferedReader inlineReader = new BufferedReader(new FileReader(inlineFile));
        BufferedReader suffixReader = new BufferedReader(new FileReader(suffixFile))) {

      StringBuilder line = new StringBuilder();
      String prefix, inline, suffix;
      while ((prefix = prefixReader.readLine()) != null) {
        //assuming that nothing fails and the files are equals in # of lines.
        inline = inlineReader.readLine();
        suffix = suffixReader.readLine();
        line.append(prefix).append(inline).append(suffix).append("\r\n");
        // write it
        ...

      }
    } finally {/*close writers*/}
  }