OAuthService service = new ServiceBuilder()
                .apiKey(APIKEY)
                .apiSecret(SECRETKEY)
                .provider(LinkedInApi.class)
                .build();

    OAuthRequest oAuthRequestData = new OAuthRequest(Verb.GET, DATAENDPOINT);
    oAuthRequestData.addHeader("x-li-format", "json");
    Token accessToken = new Token(oauth_token, oauth_token_secret);
    service.signRequest(accessToken, oAuthRequestData);
    Response oAuthResponse = oAuthRequestData.send();
    System.outt.println(oAuthResponse.getBody());