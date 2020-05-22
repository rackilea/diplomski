System.setProperty("twitter4j.oauth.consumerKey", "your token");
System.setProperty("twitter4j.oauth.consumerSecret", "your token secret");

Twitter twitter = new TwitterFactory().getInstance(login, password);

AccessToken accessToken = twitter.getOAuthAccessToken();