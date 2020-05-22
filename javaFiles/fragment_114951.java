// method to determine whether two strings have the same chars
public static boolean sameChars(String wordOne, String wordTwo) 
{
    lettersOnly(wordOne);
    lettersOnly(wordTwo);
    wordOne = lettersOnly(wordOne);
    wordTwo = lettersOnly(wordTwo);

    ...
}