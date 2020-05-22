public static String formatPlainText(String sentence) 
{
    String replacedSentence = "";

    for(int i = 0; i< sentence.length() ; i++){
        char ch = sentence.charAt(i);

        if (Character.isUpperCase(ch)) {
            replacedSentence += ch;
        }
        else {
            replacedSentence += " ";
        }
    }   

    return replacedSentence;
}