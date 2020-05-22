while( input.hasNextLine() )
{
    String currentLine = input.nextLine();
    numLines++;
    numChars+= currentLine.length();

    String [] words = currentLine.split("\\s+");
    int count = words.length;
    for (int i = 0; i < words.length; i++) {
        if (words[i].equals("")) {
            count--;
        }
    }
    numWords += count;
}