public class PoliticCard {
    private ArrayList<Color> politicCards;

    /**
     * @return the politicCards
     */
    public ArrayList<Color> getPoliticCards() {
        return politicCards;
    }
    /**
     * @param politicCards the politicCards to set
     */
    public void setPoliticCards(ArrayList<Color> politicCards) {
        this.politicCards = politicCards;
    }

    public void setDeck() {
        setPoliticCards(new ArrayList<Color>());
        getPoliticCards().add(Color.BLACK);
        getPoliticCards().add(Color.PURPLE);
        getPoliticCards().add(Color.BLUE);
    }

    public void drawPoliticCard(Player player) {
        player.getPoliticCards().add(getPoliticCards().get(0));
        getPoliticCards().remove(0);
    }

}