//  
// is valid checks to see if only lower case characters  
//  
private static boolean isValid(final String chkWord)
{
  // returns true only if the match is lower case a-z
  return chkWord.matches("^[a-z]+$");
}

private static String encryptWord(String word, String key)
{
  // TODO: implement the encryption algorithm;
  //   The algorithm would use the key to do the encryption;
  // here will just add to character as quick example
  char[] wordChars = word.toCharArray();

  for (int i = 0; i < wordChars.length; ++i) {
      char c = wordChars[i];
      if (c >= 'a' && c <= 'm') { c += 13; }
      else if (c >= 'n' && c <= 'z') { c -= 13; }
      wordChars[i] = c;
  }

  return new String(wordChars);
}

private static String decryptWord(String word, String key)
{
  // TODO: implement the decryption algorithm
  return "NEED TO IMPLEMENT";
}

private static String getWord()
{ 
  // the word should be gathered from the user in some fashion
  // using the In class that is provided
  return "helloworld"; 
}

private static String getKey()
{
  // the key should be gathered from the user in some fashion
  // using the In class that is provided
  return "doit";
}

public static void main(String[] args)
{
  final String word = getWord();
  final String key = getKey();

  boolean validWord = isValid(word);
  System.out.printf("Is valid [%s]: %b%n", word, validWord);

  if (! validWord) {
    System.err.println("Not a good word!");
    return;
  }

  String encrypted = encryptWord(word, key);
  System.out.printf("Encrypted %s: %s%n", word, encrypted);

  String decrypted = decryptWord(word, key);
  System.out.printf("Encrypted %s: %s%n", word, decrypted);

}