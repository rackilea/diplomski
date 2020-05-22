String sample = "1,2,3,4,5";
StringTokenizer tokenizer = new StringTokenizer(sample,",");

while(tokenizer.hasMoreTokens()) {
  int convertedToInt = Integer.parseInt(tokenizer.nextToken());
}