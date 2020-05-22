Reader r; // initialized somehow by you
Tokenizer<CoreLabel> tokenizer = new PTBTokenizer<CoreLabel>(r, new CoreLabelTokenFactory(), "");
while (tokenizer.hasNext()) {
  CoreLabel token = tokenizer.next();
  System.out.println(token);
}