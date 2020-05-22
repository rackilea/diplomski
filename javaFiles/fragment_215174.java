public static String getOAuthHeader(final String url, final String method,
        final String realm, final String consumerSecret,
        final String consumerKey, final String callback,
        final String verifier, final String token,
        final String tokenSecret, final String host) {

    String oauthHeader = null;
    OAuthSecrets secrets = new OAuthSecrets()
            .consumerSecret(consumerSecret);
    OAuthParameters authParams = new OAuthParameters()
            .consumerKey(consumerKey).signatureMethod(HMAC_SHA1.NAME)
            .version(AuthenticationConstants.OAUTH_VERSION_10A)
            .realm(realm).nonce().timestamp();

    if (callback != null) {
        authParams = authParams.callback(callback);
    }

    if (verifier != null) {
        authParams = authParams.verifier(verifier);
    }

    if (token != null) {
        authParams = authParams.token(token);
    }

    if (tokenSecret != null) {
        secrets = secrets.tokenSecret(tokenSecret);
    }

    final OAuthRequestData request = new OAuthRequestData();
    request.setRequestMethod(method);
    request.setRequestURL(url);
    request.addHeaderValue(AuthenticationConstants.HOST_HEADER, host);

    try {

        OAuthSignature.sign(request, authParams, secrets);

        final List<String> header = request
                .getHeaderValues(OAuthParameters.AUTHORIZATION_HEADER);
        oauthHeader = header.get(0);
    } catch (final OAuthSignatureException oae) {
        //handle this exception
    }

    return oauthHeader;
}