Set<Integer> tweetIds = new HashSet<Integer>(); // or long, whatever
for (Tweet tweet : tweets) {
    if (!tweetIds.contains(tweet.getId())) {
        db.insertTweet(tweet.getText(), tweet.getId());
        tweetIds.add(tweet.getId());
    }
}