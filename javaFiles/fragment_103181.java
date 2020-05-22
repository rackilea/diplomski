Integer oldId;
for (Tweet tweet : tweets) {
    if (oldId == null || oldId != tweet.getId()) {
        db.insertTweet(tweet.getText(), tweet.getId());
    }
    oldId = tweet.getId();
}