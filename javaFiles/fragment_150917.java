IIndexWord idxWord = dict.getIndexWord("dog", POS.NOUN);
    IWordID wordID = idxWord.getWordIDs().get(0);
    IWord word = dict.getWord(wordID);
    ISynset synset = word.getSynset();
    String LexFileName = synset.getLexicalFile().getName();
    System.out.println("Lexical Name : "+ LexFileName);