import java.util.*;

class Score implements Comparable<Score> {
    int score;
    String name;

    public Score(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public int compareTo(Score o) {
        return score < o.score ? -1 : score > o.score ? 1 : 0;
    }
}

public class Test {

    public static void main(String[] args){
        List<Score> scores = new ArrayList<Score>();

        scores.add(new Score(23, "Peter"));  
        scores.add(new Score(11, "Tony"));  
        scores.add(new Score(110, "Claire"));  
        scores.add(new Score(13, "ferca"));  
        scores.add(new Score(55, "Julian"));  
        scores.add(new Score(13, "Pedro"));

        Collections.sort(scores);
    }
}