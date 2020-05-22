int countTweets(String hashtag){
  int total = 0;
  for(String tweet : tweets){
    if(tweet.contains(hashtag)){
      total++;
    }
  }
  return total;
}