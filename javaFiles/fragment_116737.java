public String getTheWord(String textToSearch, String searchingFor,
  int currentLineNumber) {

    // Separate the text into lines.
    String[] lines = textToSearch.split('\n');

    // Get the first line of the (remaining) text.
    String firstLine = lines[0];

    // We're going to have some result from this method call: either
    // an empty string or a message indicating that we found the word.
    String resultFromThisLine = "";        

    // Now, look for the word.
    if (firstLine.contains(searchingFor)) {
        // We found it.
        resultFromThisLine = currentLineNumber + ": " + firstLine + "\n";
    }

    // Now we check to see if there are any lines left.
    if (lines.length == 1) {
        // This was the last line.
        return resultFromThisLine;
    } else {
        // There are more line(s).
        // Create a string with all lines but the first one.
        String remainingLines = "";
        for (int i=1; i<lines.length; i++) {
            remainingLines += lines[i] + "\n";
        }


        // Here's the key part.
        // Take the result from this line, add it to the result from the
        // next line, and return *that*.

        return resultFromThisLine + getTheWord(remainingLines, searchingFor,
          currentLine + 1);

     }
}