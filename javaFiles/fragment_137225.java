OAuthConsumer consumer = new DefaultOAuthConsumer('YOUR CLIENT ID', 'YOUR CLIENT SECRET');
    URL url = new URL("http://social.yahooapis.com/v1/me/guid?format=json");
    HttpURLConnection request1 = (HttpURLConnection) url.openConnection();
    consumer.setTokenWithSecret('TOKEN', 'TOKEN SECRET');
    consumer.sign(request1);
    request1.connect();
    String responseBody = convertStreamToString(request1.getInputStream());