String reduceToOneLine(String input){
    // Note that this means both \r and \n are tokens, not that they have to appear together.
    StringTokenizer tokenizer = new StringTokenizer(input, "\r\n"); 
    StringBuffer output = new StringBuffer();
    while(tokenizer.hasMoreTokens()){
        output.append(tokenizer.nextToken());
    }
    return output.toString();
}