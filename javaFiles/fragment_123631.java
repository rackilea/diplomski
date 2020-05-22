public String stringX(String str) {

  // Create an empty string to hold the input without 'x's
  String result = "";

  // Loop for as many characters there are in the string
  for (int i=0; i<str.length(); i++) {

    // If the current character we're looking at isn't the first OR last character
    // and we check to see if that character equals 'x', then we take the opposite
    // of this entire value.
    // Another way to read this logic is:
    // If the character we're looking at is the first OR the last OR it doesn't equal 'x',
    // then continue (return true)
    if (!(i > 0 && i < (str.length()-1) && str.substring(i, i+1).equals("x"))) {

      // We add this character to our output string
      result = result + str.substring(i, i+1); // Could use str.charAt(i) here
    }
  }

  // Return our output string
  return result;
}