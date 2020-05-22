final XMLLexicon xmlLexicon = new XMLLexicon();
final WordElement word = xmlLexicon.getWord("elves", LexicalCategory.NOUN);
final InflectedWordElement singularWord = new InflectedWordElement(word);
WordElement sw = singularWord.getBaseWord();
final Realiser realiser = new Realiser(xmlLexicon);
System.out.println(realiser.realise(sw));