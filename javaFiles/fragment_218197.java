LineIterator it = IOUtils.lineIterator(
       new BufferedReader(new FileReader("file.txt")));
 for (int lineNumber = 0; it.hasNext(); lineNumber++) {
    String line = (String) it.next();
    if (lineNumber == expectedLineNumber) {
        return line;
    }
 }