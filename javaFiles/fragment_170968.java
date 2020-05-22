LineIterator it = IOUtils.lineIterator(new BufferedReader(new FileReader("inputfile.txt")));
 for (int lineNoInFile = 0; it.hasNext(); lineNoInFile++) {
    String outputLine = (String) it.next();
    if (lineNoInFile == inputLineNumber) {
        return outputLine;
    }
 }