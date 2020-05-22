while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    while (line != null) {
       String word = scanner.next();
       addWord(word, linecount);
    }
    linecount++;
}