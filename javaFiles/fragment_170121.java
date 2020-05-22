Twitter twitter = new Twitter();
twitter.setOAuthConsumer(consumerKey,consumerSecret);
RequestToken requestToken = twitter.getOAuthRequestToken();

String token = requestToken.getToken();
String tokenSecret = requestToken.getTokenSecret();

HttpSession session = request.getSession();
session.setAttribute("token",token);
session.setAttribute("tokenSecret",tokenSecret);