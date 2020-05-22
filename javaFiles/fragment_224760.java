OAuthClientRequest request = OAuthClientRequest
                //.authorizationProvider(OAuthProviderType.INSTAGRAM)
                .tokenLocation(ACCESS_TOKEN_URL)
                .setGrantType(GrantType.AUTHORIZATION_CODE)
                .setClientId(CLIENT_ID)
                .setClientSecret(CLIENT_SECRET)
                .setRedirectURI(REDIRECT_URL)
                .setCode(authorizationCode)
                .buildBodyMessage();