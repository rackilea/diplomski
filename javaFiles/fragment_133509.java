Pattern newLinePattern = Pattern.compile("(\\r\\n?|\\n)", Pattern.MULTILINE);
    String sourceString = "\r\n\n\r\r\n\n";
    Scanner scan = new Scanner(sourceString);
    int count = 0;
    while (scan.findWithinHorizon(newLinePattern, 0) != null) {
        count++;
    }
    System.out.println("found "+count+" newlines"); // finds 5 newlines