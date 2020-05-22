public class Card {
    private String name;
    .
    .
    .
    .

    public Card(String name, ........) {
        this.name = name; // set the name of the card to its global variable
    }
}


public class Main {
    public static void main(String [] args) {
        // create as many card objects you like
        // in the constructor, send appropriate card values for each card
        Card card8 = new Card("card8", ........);
        Card card9 = new Card("card9", ........);
    }
}