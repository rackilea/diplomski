public String CaesarCipher(int shift, String message) {
  String result = "";
  for (int i = 0; i < message.length(); i++) {
    char letter = message.charAt(i);

    if (Character.isUpperCase(letter)) {
      int ascii = (int) letter;
      ascii += shift;
      result += Character.toString((char)ascii);
    } else {
      result += Character.toString(letter);
    }
  }
  return result;
}