import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterUtils {

public static void main(String[] args) {
    try {

        final String consumerKey = "**********";
        final String consumerSecret = "**********";
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(consumerKey, consumerSecret);
        RequestToken requestToken = twitter.getOAuthRequestToken();

        String token = requestToken.getToken();
        String tokenSecret = requestToken.getTokenSecret();
        System.out.println("My token :: " + token);
        System.out.println("My token Secret :: " + tokenSecret);

        //AccessToken a = new AccessToken(token, tokenSecret);
        //twitter.setOAuthAccessToken(a);
        twitter.updateStatus("If you're reading this on Twitter, it worked!");

    } catch (TwitterException e) {
        e.printStackTrace();
    }
}//main
}/