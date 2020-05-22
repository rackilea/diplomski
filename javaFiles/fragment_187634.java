StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(System.in));

while(tokenizer.nextToken() != StreamTokenizer.TT_EOF){

    if(tokenizer.ttype == StreamTokenizer.TT_WORD) {
        // found a word.
        System.out.println(tokenizer.sval);
    }
}