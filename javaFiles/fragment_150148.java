URL target = new URL("https://api.parse.com/1/push");
HttpURLConnection connection = (HttpURLConnection) target.openConnection();
connection.setRequestMethod("POST");
connection.setRequestProperty("Content-Type", "application/json");
connection.setRequestProperty("X-Parse-REST-API-KEY", "${REST_API_KEY}");
connection.setRequestProperty("X-Parse-Application-Id", "${APPLICATION_ID}");

connection.setDoInput(true);
connection.setDoOutput(true);

String notification = 
        "\"where\": {\"deviceType\": \"android\",\"deviceToken\": { \"$in\" :" + deviceTokens.toString() + "}},"+
        "\"data\": {\"alert\": \"A test notification from Parse!\" }";
try (OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream())) {
    out.write(notification);
}

connection.connect();
if (connection.getResponseCode() != 201) {
    log.error("Notification Failed");
}