private List<TextChunks> finalTextChunks(List<TextChunks> textchunkswithkeyword) {

   private List<TextChunks> result = new ArrayList<TextChunk>();
   private List<String> wordList = new ArrayList<String>();

   // store all words in an arraylist, words are stored at their correct positions,
   // ignored words from the original text are represented by null entries
   for (TextChunks chunk : textchunkswithkeyword) {
     int start = chunk.getStartTextchunks();
     List<Token> tokens = chunk.getTokens(); // TODO - implement getTokens() in TextChunks class
     for (int i = 0; i < tokens.length; i++) {
        wordList.set(start+i, tokens.get(i).toString()); // TODO - overwrite toString() in Token class
     }
   }

   // recreate the chunks
   int start = 0;
   boolean isChunk = false;
   StringBuilder chunkBuilder;

   for (int i = 0; i < wordList.size(); i++) {
     String word = wordList.get(i);
     if (word == null) {
       if (isChunk) {
         // end of chunk detected
         TextChunk chunk = new TextChunk(chunkBuilder.toString().split(" "), start, i);
         result.add(chunk);
         isChunk = false;
       } else {
         // do nothing
       }
     } else {
       if (isChunk) {
         // chunk gets longer by one word
         chunkBuilder.append(" ").append(word);
       } else {
         // new chunk starts here
         chunkBuilder = new StringBuilder(word);
         start = i;
         isChunk = true;
       }
   }
   if (isChunk) {
     // create and add the last chunk
     TextChunks chunk = new TextChunk(chunkBuilder.toString(), start, wordList.size()-1);
     result.add(chunk);
   }
   return result;
}