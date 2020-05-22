private Runnable defineMonitoringRunnable(final TweetRepository tweetRepository) {
    return new Runnable() {

        @Override
        public void run() {
            List<String> tempTweets = new ArrayList<String>();

            while (true) {
                if (tweets.size() > 0) {
                    tempTweets.clear();
                    tweets.drainTo(tempTweets);

                    tweetRepository.insert(tempTweets);   
                }

                try {
                    Thread.sleep(TWEETS_SAVING_TIME);
                } 
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }
        }
    };
}