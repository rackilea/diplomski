class DeckFactory {

    public static Deck createDeckFromFile(File deckFile) {
        String fileString = readFileToString(deckFile); // not-shown helper method

        // depending on how information is stored in string, get fields from string, i.e.:
        String[] fields = fileString.split(":"); // if fields were delimited by :
        String deckName = fields[0]; 
        // and other etc. fields...

        // then construct your deck
        return new Deck(deckName, deckSize, deckType); // and other properties...
    }
}