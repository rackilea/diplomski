String authString = RedditConstants.REDDIT_CLIENT_ID + ":";
String encodedAuthString = 
       Base64.encodeToString(authString.getBytes(), Base64.NO_WRAP);

Map<String, String> headers = new HashMap<>();
headers.put("Authorization", "Basic " + encodedAuthString);

Map<String, String> fields = new HashMap<>();
fields.put("grant_type", "authorization_code");
fields.put("code", code);
fields.put("redirect_uri", RedditConstants.REDDIT_REDIRECT_URL);
fields.put("User-Agent", RedditConstants.REDDIT_USER_AGENT);


Call<RedditAccessToken> call = api.login(headers, fields);
call.enqueue(new Callback<RedditAccessToken>()