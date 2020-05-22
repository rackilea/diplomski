// Takes Strings like "[a, b, c]"
public List parse(String s) {
  List output = new ArrayList();
  String listString = s.substring(1, s.length() - 1); // chop off brackets
  for (String token : new StringTokenizer(listString, ",")) {
    output.add(token.trim());
  }
  return output;
}