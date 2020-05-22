public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Card[] myHand = new Card[3];

        //King of Spades
        myHand[0] = new Card(Card.KING, Card.SPADES);
        //Ace of spades
        myHand[1] = new Card(Card.ACE, Card.SPADES);
        //two of hearts
        myHand[2] = new Card(2, Card.HEARTS);

        printHand(myHand);
    }

    public static void printHand(Card[] hand) {

        System.out.println("The hand concists of the following cards");

        for(Card card : hand) {

            System.out.println(card.toString());
        }
    }

}