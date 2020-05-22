import java.util.ArrayList;
public class Deck
{

    final int SUITS = 4;
    final int RANKS = 13;

    public void someMethod() {
        //ARRAY
        double[][]card = new double[SUITS][RANKS];
        for (int suits=0; suits<SUITS; suits++)
        {
            for(int ranks=0; ranks<RANKS; ranks++)
            {
                cards[suits][suits] = new Card();
            }
        }
    }
}