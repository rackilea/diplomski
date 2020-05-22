public class CardAndPairs implements Comparable<CardAndPairs> {
    Card card;
    List<Pair> pairs;

    public CardAndPairs(Card card, Set<Pair> allPairs) {
       this.card = card;
       pairs = new HashSet<>();
       for (Pair pair : allPairs) 
         if (pair.contains(card))
           pairs.add(pair);
       // You could then reorder "pairs" by the value of the other card
       // ... see below
    }

    @Override
    public int compareTo(CardAndPairs other) {
       int diff = pairs.size() - other.pairs.size();
       if (diff > 0)
          return 1;
       if (diff == 0)
          return card.compareTo(other.card);
       return 1;
    }
}