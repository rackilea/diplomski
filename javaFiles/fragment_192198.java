while (scanner.hasNextLine()) {{
    String line = scanner.nextLine();

    Scanner lineScanner = new Scanner(line);
    while(lineScanner.hasNext()) {
        addWord(lineScanner.next(), linecount);
    }

    linecount++;
}