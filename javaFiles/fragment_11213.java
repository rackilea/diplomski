public class Tweet {

    List<Tweet> tweets = new ArrayList<Tweet>();
    String title;
    String body;

    public Tweet() {
        setTweets();
    }

    private void setTweets() {
        for(int i = 0; i <20; i++ ) {
            Tweet tweet = new Tweet();
            tweet.setTitle("A nice header for Tweet # " +i);
            tweet.setBody("Some random body text for the tweet # " +i);
            tweets.add(tweet);
        }
        TweetAdapter tweetItemArrayAdapter = new TweetAdapter(this, new String[10]);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

}