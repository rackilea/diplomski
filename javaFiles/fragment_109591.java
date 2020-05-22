while(lineScanner.hasNext()){
    String currentToken = lineScanner.next();
    currentToken = currentToken.trim();  // line to add
    if (this.wordToReplace.contains(currentToken)){
        bufferedFileWriter.write("xxx, ");
    }
    else {
        bufferedFileWriter.write(currentToken + ", ");
    }

}