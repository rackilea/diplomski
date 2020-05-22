public abstract class Card {
    protected Player owner; // Assume there's a constructor that sets this
    public abstract void anotherCardWasPlayed(Card theOtherCard);
}

public class GuyCard extends Card {
    public void anotherCardWasPlayed(Card theOtherCard) {
        owner.gainLife(2);
    }
}