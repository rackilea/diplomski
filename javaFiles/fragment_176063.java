public void init() {
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
      .setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET)
      .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
      .setOAuthAccessTokenSecret(TWITTER_ACCESS_SECRET);
    TwitterFactory tf = new TwitterFactory(cb.build());
    twitter = tf.getInstance();
}


/***
 * 
 * @param tweetId : tweet Id
 * @param messgae : Reply message
 * @return
 * @throws TwitterException
 */
public String reply(String tweetId, String messgae ) throws TwitterException {
        Status status = twitter.showStatus(Long.parseLong(tweetId));
        Status reply = twitter.updateStatus(new StatusUpdate(" @" + status.getUser().getScreenName() + " "+ messgae).inReplyToStatusId(status.getId()));
    return Long.toString(reply.getId());
}