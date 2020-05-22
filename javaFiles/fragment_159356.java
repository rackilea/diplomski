Twitter twitter = new TwitterFactory().getInstance();
try {
    QueryResult result = twitter.search(new Query("#myhashtag"));
} catch (TwitterException te) {
    te.printStackTrace();
}