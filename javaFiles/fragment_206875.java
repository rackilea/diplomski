String createRegex(String pattern) {
  String result = pattern.replaceAll("[^ANT]+", "\\Q$0\\E");
  result = result.replaceAll("A", "[0-9a-zA-Z]");
  result = result.replaceAll("T", "[a-zA-Z]");
  result = result.replaceAll("N", "[0-9]");
  return "^" + result + "$";
}