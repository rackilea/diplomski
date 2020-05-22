//1. Search Twitter
SearchResults results = twitterTemplate.searchOperations().search("#WinterIsComing");
List<Tweet> tweets = results.getTweets();
int i =0;
for (Tweet tweet : tweets) {
    System.out.println(tweet.getUser().getName() + " Tweeted : "+tweet.getText() + " from " + tweet.getUser().getLocation() 
            + " @ " + tweet.getCreatedAt() + tweet.getUser().getLocation()  );
}

//2. Search Place by GeoLocation        
RestTemplate restTemplate = twitterTemplate.getRestTemplate();
GeoTemplate geoTemplate = new GeoTemplate(restTemplate, true, true);
List<Place> place = geoTemplate.search(37.423021, -122.083739);
for (Place p : place) {
    System.out.println(p.getName() + " " + p.getCountry() + " "+p.getId());
}           

//3. Get Twitter UserProfile
TwitterProfile userProfile = twitterTemplate.userOperations().getUserProfile();
System.out.println(userProfile.getName()+" has " +userProfile.getFriendsCount() + " friends");