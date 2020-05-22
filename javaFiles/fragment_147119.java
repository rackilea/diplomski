//Twitter Conf.
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
            .setOAuthConsumerKey(CONSUMER_KEY)
            .setOAuthConsumerSecret(CONSUMER_SECRET)
            .setOAuthAccessToken(ACCESS_KEY)
            .setOAuthAccessTokenSecret(ACCESS_SECRET);

    TwitterFactory tf = new TwitterFactory(cb.build());
    Twitter twitter = tf.getInstance();