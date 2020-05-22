import java.util.ArrayList;

public class What2Think {

    public static void main(String[] args) {
        ArrayList<String> tweets = new ArrayList<String>();
        tweets.add("In this country, \"democracy\" means pro-government. #irony");
        NLP.init();
        for(String tweet : tweets) {
            System.out.println(tweet + " : " + NLP.findSentiment(tweet));
        }
    }
}