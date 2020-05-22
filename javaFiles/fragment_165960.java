private static void GetTweetStreamForKeywords()
        {
        TwitterStream twitterStream = new TwitterStreamFactory(config).getInstance();

        StatusListener statusListener = new StatusListener() {

         @Override
         public void onStatus(Status status) {
           // The main section that you get the tweet. You can access it by status object.
           // You can save it in a database table.
         }


                @Override
                public void onDeletionNotice(StatusDeletionNotice sdn) {
                    throw new UnsupportedOperationException("Not supported yet."); 
                }

                @Override
                public void onTrackLimitationNotice(int i) {
                    throw new UnsupportedOperationException("Not supported yet."); 
                }

                @Override
                public void onScrubGeo(long l, long l1) {
                    throw new UnsupportedOperationException("Not supported yet."); 
                }

                @Override
                public void onStallWarning(StallWarning sw) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public void onException(Exception ex) {
                    logWriter.WriteErrorLog(ex, "onException()");
                }
            };

            FilterQuery fq = new FilterQuery();        

            String keywords[] = {"sport", "politics", "health"};

            fq.track(keywords);        

            twitterStream.addListener(statusListener);
            twitterStream.filter(fq);          
      }