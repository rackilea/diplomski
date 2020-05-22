class Tweets {
     public List<Tweet> tweets;
}

class Tweet {
     String filterLevel;
     RetweetedStatus retweetedStatus;
     String text;
     // + any other fields you may receive and want to deserialize
}

// + any other classes the define nested objects like RetweetedStatus