import java.util.ArrayList;
import static java.util.Collections.shuffle;

class Deck {
    private static ArrayList<Integer> deck = new ArrayList<Integer>();
    // constructor
    public Deck() {
        for (int i=1; i <= 52; ++i)
            deck.add(i);
        shuffle(deck);
    }

    public void deal(int n) {
        for (int i=0; i < n; ++i)
           System.out.println(deck.get(i));
    }

    public static void main(String[] args) {
         Deck d = new Deck();
         d.deal(4);
    }

}