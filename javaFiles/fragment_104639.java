TwitterStream twitterStream = new TwitterStreamFactory(new ConfigurationBuilder().setJSONStoreEnabled(true).build()).getInstance();

    twitterStream.setOAuthConsumer(_consumerKey, _consumerSecret);
    AccessToken token = new AccessToken(_accessToken, _accessTokenSecret);
    twitterStream.setOAuthAccessToken(token);

    StatusListener listener = new StatusListener() {
        public void onStatus(Status status) {
            logger.info(DataObjectFactory.getRawJSON(status));

            //do your action here
        }

        ...
    };

    twitterStream.addListener(listener);

    FilterQuery query = new FilterQuery();
    query.follow(new long[] { _twitterUserId });
    twitterStream.filter(query);
}