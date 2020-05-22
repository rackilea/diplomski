// getting user profile
OAuthService service = new ServiceBuilder()
                                  .provider(FacebookApi.class)
                                  .apiKey(YOUR_API_KEY)
                                  .apiSecret(YOUR_API_SECRET)
                                  .build();
OAuthService service = facebookServiceProvider.getService();
OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, "https://graph.facebook.com/v2.2/me"); //See how this link is appended with v2.2 path!!!
service.signRequest(accessToken, oauthRequest);
Response oauthResponse = oauthRequest.send();
System.out.println(oauthResponse.getBody());