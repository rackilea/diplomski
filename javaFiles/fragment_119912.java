OAuthParameters params = new OAuthParameters().signatureMethod("HMAC-SHA1").
    consumerKey("consumerKey").version("1.1");

OAuthSecrets secrets = new OAuthSecrets().consumerSecret("secretKey");
OAuthClientFilter filter = new OAuthClientFilter(client().getProviders(), params, secrets);


WebResource webResource = resource();
webResource.addFilter(filter);

String responseMsg = webResource.path("oauth").get(String.class);