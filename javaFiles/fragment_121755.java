import java.util.ArrayList;

public class Answers {

     public static void main(String[] args) {
         Answers main = new Answers();
         // Original Deck
         ArrayList<Integer> cards = new ArrayList<Integer>();

         // Add to original deck
         cards.add(1);
         cards.add(2);
         cards.add(3);
         cards.add(4);
         cards.add(5);

         System.out.println("Removed Cards Deck: " + main.deal(3, cards));
             // Removed Cards Deck: [1, 2, 3]

          System.out.println("Original Deck: " + cards); 
             // Original Deck: [-1, -1, -1, 4, 5]
     }

     public ArrayList<Integer> deal(int numCards, ArrayList<Integer> deckOfCards) { 
          // Deck that will contain the removed cards
          ArrayList<Integer> newCardsArray = new ArrayList<Integer>();

          for (int i = 0; i < numCards; i++) { 
               newCardsArray.add(deckOfCards.get(i)); 
                    // Add to remove cards deck

               deckOfCards.set(i, -1); 
                    // Set taken cards in original deck to '-1'
          }
          return newCardsArray;
     }

}