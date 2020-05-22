public class test {

private static String wordToGuess = "quorum";
private static String wordSoFar = "______";

public static void main(String[] args) {
    wordSoFar = showLetter('r');
    System.err.println(wordSoFar);
    wordSoFar = showLetter('q');
    System.err.println(wordSoFar);
    wordSoFar = showLetter('m');
    System.err.println(wordSoFar);

}

public static String showLetter(char letter) {
    for (int i = 0; i < wordToGuess.length(); i++) {
       if (wordToGuess.charAt(i) == letter) {
           wordSoFar = wordSoFar.substring(0,i)+letter+wordSoFar.substring(i+1); 
         }
     }
    return wordSoFar;
}