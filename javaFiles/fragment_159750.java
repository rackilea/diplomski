Map<String, String> emailContent = new HashMap<>();
emailContent.put("email", "example@example.com");
Map<String, Object> postContent = new HashMap<>();
postContent.put("customer", emailContent);
postContent.put("password", "password");
given().contentType(ContentType.JSON)
    .header("Authorization", "Bearer "+srtToken)
    .with().body(postContent)
    .when().post(srtAmbiente+srtAPI)
    .then().statusCode(200);