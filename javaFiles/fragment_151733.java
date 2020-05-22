int totalWordLength = 0;
String longest = "";
while (in.hasNextLine()) {
    String dictionaryword = in.nextLine();
    totalWordLength += dictionaryword.length();
    dictionary.add(dictionaryword);        
    if (dictionaryword.length() > longest.length()) {
        longest = dictionaryword;
    }
}

int averageLength = Math.round(totalWordLength / (float)dictionary.size());