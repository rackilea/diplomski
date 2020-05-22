public class Score implements Comparable<Score>{

    private String country;
    private int score;

    //write getters, setters

    public int compareTo(Score otherScore){
        return otherScore.score - this.score   // for descending
            // return this.score - otherScore.score for assending

    }
}