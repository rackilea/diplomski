public int count(String a, String[] b) {
    java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(a);
    java.util.List bList = java.util.Arrays.asList(b);
    int tokens = tokenizer.countTokens();
    int counter = tokens;
    for(int i=0;i<tokens;i++) {
        String token = tokenizer.nextToken().trim();
        if(bList.contains(token)) {
            counter--;
        }
    }
    return counter;
}