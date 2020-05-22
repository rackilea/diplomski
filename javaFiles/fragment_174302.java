public class Card implements Comparable<Card>
{
  private Rank rank;
  private Suit suit;

  ...

  public int compareTo(Card that) 
  {
    return ComparisonChain.start()
      .compare(this.rank, that.rank)
      .compare(this.suit, that.suit)
      .result();
  }
}