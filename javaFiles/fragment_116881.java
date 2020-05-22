Map<String, List<String>> headers= (Map<String, List<String>>) messageContext
                .get(MessageContext.HTTP_REQUEST_HEADERS);

//The header "Basic base64(user:password)
String authHeader = headers.get("Authorization").get(0);

//Remove "Basic "
String authtoken = authorizationHeader.split(" ")[1];

//Decode base64 and read username and password 
String token = new String(DatatypeConverter.parseBase64Binary(authtoken));
String tokenS[] = token.split(":");
String username = tokenS [0];
String password = tokenS [1];