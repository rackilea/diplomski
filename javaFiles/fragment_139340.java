private static final Type profileAndAccessTokenResponse = new TypeToken<Response<ProfileAndAccessToken>>() {
}.getType();

final Response<ProfileAndAccessToken> response = gson.fromJson(JSON, profileAndAccessTokenResponse);
System.out.println(response.response.profile.allowDev);
System.out.println(gson.toJson(response, profileAndAccessTokenResponse));