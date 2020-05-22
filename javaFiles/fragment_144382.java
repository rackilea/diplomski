//1-First we need to create the qsh 'Query String Hash'
    String httpMethod = "GET";
    String restApiPath = "rest api url without the base url";
    String urlParameters = "key=value&key1=value1";
    String qsh = String.format("%s%s%s%s%s", httpMethod, "&", restApiPath, "&", urlParameters);

//2-Encode qsh
String encodedQsh = JwtUtil.computeSha256Hash(qsh);

//3-Create JwtJsonBuilder 
    JwtJsonBuilder jwtJsonBuilder = new JsonSmartJwtJsonBuilder();
    jwtJsonBuilder.issuedAt(issuedAt);
    jwtJsonBuilder.expirationTime(expiresAt);
    jwtJsonBuilder.issuer(issuer);
    jwtJsonBuilder.subject(subject);
    jwtJsonBuilder.type("JWT");
    jwtJsonBuilder.queryHash(encodedQsh);

//4-Encode JWT token
    String encodedJwt = new         NimbusJwtWriterFactory().macSigningWriter(SigningAlgorithm.HS256, "shared-secret-    value").jsonToJwt(jwtJsonBuilder.build());

//5-Build your URL
    String urlStrg = baseUrl + restApiPath + "?" + urlParameters

//6-Open Url Connection
    URL url = new URL(urlStrg);
    httpURLConnection = (HttpURLConnection) url.openConnection();
    httpURLConnection.setRequestProperty("Accept", "application/json");
    httpURLConnection.setRequestProperty("Authorization", "JWT " + encodedJwtToken);
    httpURLConnection.setRequestMethod(httpMethod);
    int responseCode = httpURLConnection.getResponseCode();
//responseCode to check if the request is valid and authenticated