static List<Double> getElements(String fileContent, String token) {
  StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(fileContent));
  List<Double> list = new ArrayList<Double>();
  while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
    if (tokenizer.sval.equals(token)) {
      tokenizer.nextToken();  // '[' 
      do {
        tokenizer.nextToken();  // go to the number
        list.append(tokenizer.nval);
      } while (tokenizer.nextToken() == ',');
      break;
    }
  } 
  return list;
}