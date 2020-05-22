Twitter twitter = TwitterFactory.getSingleton(); 
 Query query = new Query("source:twitter4j LFC"); 
 QueryResult result = twitter.search(query); 
 for (Status status : result.getTweets()) {
    System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText()); 
    break; // You can delete the 'break' in future when you decide to implement/enhance the logic as you have stated
 }