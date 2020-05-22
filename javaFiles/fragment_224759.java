OAuthClientRequest request = OAuthClientRequest
                .authorizationLocation(AUTHORIZATION_URL)
                .setClientId(CLIENT_ID)
                .setRedirectURI(REDIRECT_URL)
                .setResponseType(ResponseType.CODE.toString())
                .setScope("public_content follower_list comments relationships likes basic")
                .buildQueryMessage();