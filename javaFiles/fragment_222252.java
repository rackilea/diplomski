try {
    total = readFile(inputFile);
    //Check to make sure we got the text files data
    System.out.println("The total string says: \n" + total);
    //Call the reverseWords method to switch 'Hello' with 'World'
    String info = reverseWords(total);
    //Check to make sure the string was reversed
    System.out.println("The reversed string says: \n" + info);
    writeFile(outputFile, info);
} catch (FileNotFoundException ex) {
    System.out.println("Unable to open file '" +
                               inputFile + "'");
} catch (IOException ex) {
    System.out.println("Error reading file '" + inputFile + "'");
    // Or we could just do this:
    // ex.printStackTrace();
}