import java.util.Arrays;
import java.util.HashSet;

public class QuickTester {

    public static void main(String[] args) {

        String[] hands = new String[]{"Zilch", "Pair", "Triple", 
                "Straight", "Full House"};

        HashSet<String> hs = new HashSet<>(Arrays.asList(hands));

        if(hs.size() == hands.length) {
            System.out.println("All elements in array are different!");
        }
        else {
            System.out.println("Duplicates found in array!");
        }

        hands = new String[]{"Banana", "Apple", "Orange",
                "Banana"};

        hs = new HashSet<>(Arrays.asList(hands));

        if(hs.size() == hands.length) {
            System.out.println("All elements in array are different!");
        }
        else {
            System.out.println("Duplicates found in array!");
        }
    }
}