try {
    inputFile = new BufferedReader(new FileReader(inputFileName));
    outputFile = new PrintWriter(new FileWriter(outputFileName));
    String lineOfText = inputFile.readLine();
    while (lineOfText != null) {
        if (lineOfText.contains("x")) {
            lineOfText = lineOfText.replaceAll("x"+ ".*", "");
        } 
        outputFile.println(lineOfText);
        lineOfText = inputFile.readLine();
    } 
} catch(IOException ioe) {
        System.err.println("Caught IOException: " + ioe.getMessage());
} finally {
    if(inputFile != null)
        inputFile.close();
    if(outputFile != null)
        outputFile.close();
}