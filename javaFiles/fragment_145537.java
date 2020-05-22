public static List<String> tokenize(String s) throws IOException {
  StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(s));
  tokenizer.ordinaryChar('-');  // Don't parse minus as part of numbers.
  tokenizer.ordinaryChar('/');  // Don't treat slash as a comment start.
  List<String> tokBuf = new ArrayList<String>();
  while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
    switch(tokenizer.ttype) {
      case StreamTokenizer.TT_NUMBER:
        tokBuf.add(String.valueOf(tokenizer.nval));
        break;
      case StreamTokenizer.TT_WORD:
        tokBuf.add(tokenizer.sval);
        break;
      default:  // operator
        tokBuf.add(String.valueOf((char) tokenizer.ttype));
    }
  }
  return tokBuf; 
}