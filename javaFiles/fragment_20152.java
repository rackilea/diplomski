RxHttpClient client = RxHttpClient.create( new URL("${keycloak.base-url}/"));
HashMap<String,String> data = new HashMap<>();
data.put("client_id","admin-cli");
data.put("grant_type","password");
data.put("username", kConfiguration.getAdminUser());
data.put("password", kConfiguration.getAdminSecret());
MutableHttpRequest<HashMap<String, String>> request = HttpRequest
        .POST("/auth/realms/master/protocol/openid-connect/token", data)
        .contentType(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
        .accept(MediaType.APPLICATION_JSON_TYPE);
HttpResponse<AuthenticationData> response = client.exchange(request, AuthenticationData.class)
        .blockingFirst();