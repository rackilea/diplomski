import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class SumsInLoop {

    private static List<Integer> sumOfPairs(List<Pair<Integer, Integer>> pairsOfInts) {
        List<Integer> sums = new ArrayList<>();
        for(Pair<Integer,Integer> pair : pairsOfInts) {
            sums.add(pair.getKey()+ pair.getValue());
        }
        return sums;
    }

    public static void main(String[] args) {
        List<Pair<Integer,Integer>> pairsOfInts = new ArrayList<>();
        pairsOfInts.add (new Pair<>(612673,108695 ));
        pairsOfInts.add (new Pair<>(756875,496058));
        List<Integer> sumOfPairs = sumOfPairs(pairsOfInts);
        System.out.println(sumOfPairs); 
    }
}