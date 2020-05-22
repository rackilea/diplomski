import java.util.Random;

public class Pack 
{
PlayingCard[] cards = new PlayingCard[52];

public Pack()
{
    // Setting up array
    String[] suits = {"SPADES", "CLUBS", "HEARTS", "DIAMONDS"};
    String[] ranks = {"TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};

    // Intialising array

        for (int i = 0; i < cards.length; i++) 
        {
            cards[i] = i;
        }   
}

public void shuffle()
{
    for (int i = 0; i < 52; i++)
    {
        Random random = new Random();
        int rand = random.nextInt(50)+1;
        cards[i] = rand;   // Error 3
    }
}

@Override
public String toString()
{

}
}