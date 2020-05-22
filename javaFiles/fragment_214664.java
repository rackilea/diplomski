CloudantClient client = ClientBuilder.account("accounbt")
                        .username("username").password("password")
                        .disableSSLAuthentication().build();*/

Database db = client.database("databaseName", true);

List<JSONObject> arrayJson = new ArrayList<String>();
arrayJson.add(new JSONObject("{data:hello}"));
arrayJson.add(new JSONObject("{data:hello1}"));
arrayJson.add(new JSONObject("{data:hello2}"));
db.bulk(arrayJson);