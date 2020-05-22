Webb webb = Webb.create();
JSONObject result = webb
    .post("https://api.gupshup.io/appsdk/api/components/adduser")
    .header("Content-Type", "application/x-www-form-urlencoded")
    .header("apikey", "xxxx")
    .body("name=abcd&email=test@test.com.com&id=abc")
    .asJsonObject()
    .getBody();