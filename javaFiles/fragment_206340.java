TokenRequest tokenRequest = new TokenRequest();
    tokenRequest.setGrantType(TokenRequest.GrantTypeEnum.PASSWORD);
    tokenRequest.setUsername(username);
    tokenRequest.setPassword(password);
    tokenResponse=authorizationApi.token(tokenRequest);
    accessToken = tokenResponse.getAccessToken();