import twitter4j.conf.*;
import twitter4j.*;
import twitter4j.auth.*;
import twitter4j.api.*;

Twitter twitter;
String searchString = "cat";
Status currentTweet;

void setup ()
{
  size(800, 600);

  ConfigurationBuilder cb = new ConfigurationBuilder(); // New config obj, auth.

  cb.setOAuthConsumerKey("");
  cb.setOAuthConsumerSecret("");
  cb.setOAuthAccessToken("");
  cb.setOAuthAccessTokenSecret("");

  TwitterFactory tf = new TwitterFactory(cb.build()); 
  twitter = tf.getInstance();

  getNewTweets();
}

void draw()
{

  //get new tweet once every 10 seconds
  if (frameCount % (60*10) == 0) {
    getNewTweets();
  }

  background(0);
  fill(200);

  text("current tweet:" + currentTweet.getText(), 250, 250, 300, 200);
}

void getNewTweets() 
{

  println("Getting new tweet...");
  try
  {
    Query query = new Query(searchString);

    QueryResult result = twitter.search(query);
    currentTweet = result.getTweets().get(0);
  }
  catch (TwitterException te)
  {
    te.printStackTrace();
  }
}