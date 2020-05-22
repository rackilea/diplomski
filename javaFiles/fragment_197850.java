public class PokerHand {
  //just a POJO
}

public interface PokerHandDAO {
  public PokerHand getPokerHand(long id);
  public void updatePokerHand(PokerHand hand);
}

public class InMenoryPokerHandDAO implements PokerHandDAO {
  private static Map<Long,PokerHand> hands = new HashMap<Long,PokerHand>();

  @Override
  public PokerHand getPokerHand(long id) {
    return hands.get(id);
  }

  @Override
  public void updatePokerHand(PokerHand hand) {
    hands.put(hand.getId(), hand);
  }
}