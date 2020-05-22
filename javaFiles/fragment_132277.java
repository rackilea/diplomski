public class Card {
    private int suit;
    private int face;

    private Card(int suit, int face){
        this.suit = suit;
        this.face = face;
    }

    public int getSuit(){
        return this.suit;
    }
    public int getFace(){
        return this.face;
    }
    public static Card[] cards = new Card[52];

      static{
        int counter =0;
        for (int i=0; i<4; i++) {
            for (int j=0; j<13; j++) {
               cards[counter] = new Card(i, j);
               counter++;
            }
        }
      }
}