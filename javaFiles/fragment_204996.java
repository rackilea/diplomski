public class PairWithGivenCard 
          extends Pair implements Comparable<PairWithGivenCard> {
   Card givenCard;
   Card otherCard;

   public PairWithGivenCard(Card givenCard, Pair pair) {
      this.givenCard = givenCard;
      for (Card card : pair) // or however you get the cards from pair
         if (card != givenCard)
            otherCard = card;
   }

   @Override
   public int compareTo(PairWithGivenCard otherPair) {
      // It might be a good idea to throw 
      //   some exception if givenCard != otherPair.givenCard
      return otherCard.compareTo(otherPair.otherCard);
   }
}