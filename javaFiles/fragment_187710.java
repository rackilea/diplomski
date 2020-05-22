GsonBuilder gsonBuilder = new GsonBuilder();
Gson gson = gsonBuilder.create();

JwtConsumer jwtConsumer = getConsumer();

JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
String userStr = jwtClaims.getClaimValue("user", String.class);
User user = gson.fromJson(userStr, User.class);