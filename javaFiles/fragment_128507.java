public class Card<T extends Enum<T> & Rank> {

  private final T rank;
  private final Suit suit;

  public Card(T rank, Suit suit) 
  {
    this.rank = rank;
    this.suit = suit;
  }

  public final static <T extends Enum<T> & Rank> Comparator<Card<T>> byRank() 
  {
    return new Comparator<Card<T>>() {

      @Override
      public int compare(Card<T> o1, Card<T> o2) 
      {
        int r = compareRank(o1, o2);
        return  r != 0 ? r : compareSuit(o1,o2); 
      }
    };
  }

  public final static <T extends Enum<T> & Rank> Comparator<Card<T>> bySuit() 
  {
    return new Comparator<Card<T>>() {

      @Override
      public int compare(Card<T> o1, Card<T> o2) 
      {
        int r = compareSuit(o1,o2); 
        return r != 0 ? r : compareRank(o1, o2);
      }
    };
  }

}