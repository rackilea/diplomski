public class Card {

    private String[] suit = { "spades", "hearts", "clubs", "diamonds" };
    private String[] name = { "Ace", "Jack", "Queen", "King" };
    private int[] value = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

    public Card(String[] suit, String[] name, int[] value) {
        super();
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    public String[] getSuit() {
        return suit;
    }

    public void setSuit(String[] suit) {
        this.suit = suit;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card [suit=" + Arrays.toString(suit) + ", name="
            + Arrays.toString(name) + ", value=" + Arrays.toString(value)
            + "]";
    }
}