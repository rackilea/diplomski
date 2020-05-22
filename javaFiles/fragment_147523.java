public static void startTweets() {
    ConfigurationBuilder cb = new ConfigurationBuilder();

                         cb.setOAuthConsumerKey("*********************")
                        .setOAuthConsumerSecret("*********************")
                        .setOAuthAccessToken("*********************")
                        .setOAuthAccessTokenSecret("*********************");
    Twitter twitter = new TwitterFactory(cb.build()).getInstance();


}

    public static void getFeed(String hash)  throws TwitterException  {

        Query query = new Query("#"+hash);

        QueryResult result = twitter.search(query);

        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText());
            String username =status.getUser().getScreenName() ;

            String message = status.getText();
            twitter.showUser(username).getLocation();
            int Followers = twitter.showUser(username).getFollowersCount();

            main.AddtoList(username,message, Followers);

}