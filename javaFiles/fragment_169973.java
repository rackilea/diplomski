public List<Card> initDeck() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Card[] staff = mapper.readValue(new File("C:\\cards.json"), Card[].class);
    List<Card> cardDeck = Arrays.asList(staff);
    return cardDeck;
}