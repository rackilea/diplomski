static Map<String,Object> parse(
     StreamTokenizer tokenizer, int endToken) throws IOException {
  Map<String,Object> result = new TreeMap<String,Object>();
  while (tokenizer.nextToken() != endToken) {
    String key = tokenizer.sval;
    if (tokenizer.nextToken() != '=') {
      throw new RuntimeException("'=' expected");
    }
    if (tokenizer.nextToken() == '{') {
      result.put(key, parse(tokenizer, '}'));
    } else {
      tokenizer.nextToken();
      result.put(key, tokenizer.sval);
    }
  }
  return result;
}

static void main(String[] args) throws IOException {
  Reader reader = new FileReader(args[0]);
  Map<String,Object> parsed = parse(
     new StreamTokenizer(reader), StreamTokenizer.TT_EOF);
  System.out.println(parsed);
}