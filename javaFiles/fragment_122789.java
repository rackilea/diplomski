ArrayList<String> tweets = new ArrayList<String>();

void setup() {

  //you would actually get these from twitter,
  //but for testing let's just fill them ourselves
  int numGood = 50;
  int numBad = 50;
  for (int i = 0; i < numGood; i++) {
    tweets.add("#good");
  }
  for (int i = 0; i < numBad; i++) {
    tweets.add("#bad");
  }
}

//create a function that counts the tweets
//that contain a certain hashtag
int countTweets(String hashtag){
  int total = 0;
  for(String tweet : tweets){
    if(tweet.contains(hashtag)){
      total++;
    }
  }
  return total;
}

void draw(){

  //count the good and bad tweets
  int goodTweets = countTweets("#good");
  int badTweets = countTweets("#bad");

  //calculate color based on tweet counts
  float r = badTweets/100.0 * 255;
  float g = goodTweets/100.0 * 255;
  float b = 0;

  background(r, g, b);

}