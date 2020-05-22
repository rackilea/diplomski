private Object readResolve() {
        Word localWord = new Word(word, confidence, fontAttributes, fromDictionary, numeric, boundingBox, baseline, symbols);
        for (Symbol s : symbols) {
            s.setParentWord(localWord);
        }
        return localWord;
    }