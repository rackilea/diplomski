String resourceUrl = "https://management.azure.com";
AuthenticationContext context = new AuthenticationContext(authority, true, service);
// Acquire Token
Future<AuthenticationResult> result = context.acquireToken(
resourceUrl,
new ClientCredential(APP_ID, APP_SECRET),
null
);
String token = result.get().getAccessToken();