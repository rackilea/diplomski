while( input.hasNextLine() )
{
    String currentLine = input.nextLine();
    numLines++;
    numChars+= currentLine.length();

    ArrayList<String> words = new ArrayList<>(Arrays.asList(currentLine.split("\\s+")));
    words.removeAll(Collections.singleton(""));
    numWords += words.size();
}