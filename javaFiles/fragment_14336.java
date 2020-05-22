public static void processLinesFromPoint(int startLine, int numberOfLinesToProcess) throws IOException {
    //assume startLine = 5000
    //       numberOfLinesToProcess = 500
    Stream<String> lines = Files.lines(Paths.get(pathToYourFile)).skip(startLine).limit(numberOfLinesToProcess);
    //lines.forEach method to loop through lines 5000 to 5500  (startLine+numberOfLinesToProcess)
    //and printing each line
    lines.forEach(currentLine->{
        //here goes your logic to process each line...
        System.out.println(currentLine)
    });
}