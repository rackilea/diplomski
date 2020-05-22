public class Card {

    private Suit mySuit;
    private int myNumber; // <-- the value of the card is stored here

    public Card(Suit aSuit, int aNumber){
        // ... other code ...
        this.myNumber = aNumber; // <-- store the passed in value in the instance member
        // ... other code ...
    }

}