private static final String vowels = "AEIOUaeiou";
private static final String punct = ".,!?";

public static String pigifyLine(String oneLine) {
   StringBuilder pigified = new StringBuilder();
   boolean first = true;
   for (String word : oneLine.split(" ")) {
       if (!first) pigified.append(" ");
       pigified.append(pigify(word));
       first = false;
   }
   return pigified.toString();
}

public static String pigify(String oneWord) {
    char[] chars = oneWord.toCharArray();
    StringBuilder consonants = new StringBuilder();
    StringBuilder newWord = new StringBuilder();
    StringBuilder punctuation = new StringBuilder();
    boolean consDone = false; // set to true when the first consonant group is done

    for (int i = 0; i < chars.length; i++) {
        // consonant
        if (vowels.indexOf(chars[i]) == -1) {
            // punctuation
            if (punct.indexOf(chars[i]) > -1) {
                punctuation.append(chars[i]);
                consDone = true;
            } else {
                if (!consDone) { // we haven't found the consonants
                    consonants.append(chars[i]);
                } else {
                    newWord.append(chars[i]);
                }
            }
        } else {
            consDone = true;
            // vowel
            newWord.append(chars[i]);
        }
    }

    if (consonants.length() == 0) {
        // vowel words are "about" -> "aboutway"
        consonants.append("w");
    } 
    consonants.append("ay");

    return newWord.append(consonants).append(punctuation).toString();
}