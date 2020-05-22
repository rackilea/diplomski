Tokenizer t = new Tokenizer(yourString, "\r\n");
while (t.hasMoreTokens()) {
    String token = t.nextToken();
    //do something with token

}