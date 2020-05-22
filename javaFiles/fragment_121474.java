MultivaluedMap<String, Object> headers = requestContext.getHeaders();
headers.add(HttpHeaders.ACCEPT, "something");
headers.add("Client-ID", another something);
headers.add(HttpHeaders.AUTHORIZATION, "OAuth more something");

...

client = ClientBuilder.newClient(new ClientConfig());
client.register(new OAuth2Authenticator( API_VERSION, clientId, accessToken));