do {
        try {
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            List<MyObject> myObjects = tweets.parallelStream()
                    .map(tweet -> myTweetFunction(tweet))
                    .collect(Collectors.toList());

            query = result.nextQuery();            
            checkRateLimit(result) 

        } catch (TwitterException e){
            // do what ever you want
        }
} while (result == null || result.hasNext());