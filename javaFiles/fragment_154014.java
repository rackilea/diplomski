import java.util.ArrayList;


public class Transitions {
    private ArrayList<Pair> pairs = new ArrayList<Pair>();

    public void addPair(Pair pair){
        System.out.println(String.format("Added pair %s to transitions", pair));
        pairs.add(pair);
    }

    @Override
    public String toString() {
        return "Pairs: " + pairs;
    }
}