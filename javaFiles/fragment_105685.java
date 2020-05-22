public class Deck {

private Card[] cardArray = new Card[52];
private int currentIndex = 0;

public Deck() { //constructor
    int suits = 4;
    int cardType = 13;
    int cardCount = 0;
    for (int i = 1; i <= suits; i++)
        for (int j = 1; j <= cardType; j++) {
            cardArray[cardCount] = new Card(i, j);
            cardCount++;
        } //End loop
}

public void shuffle() {
    //Runs loop for the length of the deck
    for(int i = 0; i < cardArray.length; i++) {
        int num = (int) (Math.random() * (51 - 0)) + 0; //Creates a random number between 0 and 51; used to shuffle
        Card placeHolder = cardArray[i]; //Picks a place holder card from the deck
        cardArray[i] = cardArray[num]; //Picks two random cards and make them equal
        cardArray[num] = placeHolder; //Assigns one of the duplicate cards to the placeholder value
    } //End for
} //End shuffle

public Card[] getCardArray() {
    return cardArray;
}

public Card getRandomCard(){
    Card nextCard = cardArray[currentIndex];
    currentIndex += 1;
    return nextCard;
}


//And ends here
/////////////////////////////////////////////////


public void print() {
    for (int i = 0; i < cardArray.length; i++)
        System.out.println(cardArray[i]);
} //End print loop
}