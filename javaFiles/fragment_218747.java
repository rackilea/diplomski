RequestToken reqToken = (RequestToken) session.getAttribute(REQUEST_TOKEN);
session.removeAttribute(REQUEST_TOKEN);

if (!reqToken.getToken().equals(oauthToken)) {
        throw new TwitterException("Wrong oauth_token");
}
AccessToken token = twitter.getOAuthAccessToken(reqToken);