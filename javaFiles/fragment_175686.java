public class Player {
    private ArrayList<Color> politicCards;
    int num;

    public Player(int num) {
        this.num = num;
        politicCards = new ArrayList<Color>();
    }

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
}