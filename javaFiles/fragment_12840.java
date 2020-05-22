public static void main (String args[]) throws TwitterException {
    Twitter twitter = new TwitterFactory().getInstance();
    List<Status> statuses = twitter.getUserTimeline("google");
    String hashtag = "#AlphaGo";
    System.out.println("The Twitter page contains " 
                        + countTweets(hashtag, statuses) 
                        + " tweets with the hashtag : " + hashtag);

}

public static int countTweets(String hashtag, List<Status> statuses){
    return (int) statuses.stream()
                         .filter(x -> x.getText().contains(hashtag))
                         .count();
}