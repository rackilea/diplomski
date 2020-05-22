public static String reverse(String inputString) {
  StringBuilder reverseString = new StringBuilder();
  for(int i = inputString.length(); i > 0; --i) {
    char result = inputString.charAt(i-1);
    reverseString.append(result);
  }
  return reverseString.toString();
}