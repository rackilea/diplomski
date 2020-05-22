final XMLLexicon xmlLexicon = new XMLLexicon();
final WordElement word = xmlLexicon.getWord("apple", LexicalCategory.NOUN);
final InflectedWordElement pluralWord = new InflectedWordElement(word);
pluralWord.setPlural(true);
final Realiser realiser = new Realiser(xmlLexicon);
System.out.println(realiser.realise(pluralWord));