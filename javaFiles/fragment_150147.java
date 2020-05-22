URL target = new URL("https://api.parse.com/1/installation");
HttpURLConnection connection = (HttpURLConnection) target.openConnection();
connection.setRequestMethod("PUT");
connection.setRequestProperty("Content-Type", "application/json");
connection.setRequestProperty("X-Parse-REST-API-KEY", "${REST_API_KEY}");
connection.setRequestProperty("X-Parse-Application-Id", "${APPLICATION_ID}");

connection.setDoInput(true);
connection.setDoOutput(true);

String installationCreation = "{\"appName\":\"Your App Name\"," +
        "\"deviceType\":\"android\",\"deviceToken\":\"" + userDeviceToken + "\"}";
try (OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream())) {
    out.write(installationCreation);
}

connection.connect();
if (connection.getResponseCode() != 201) {
    log.error("User Create Failed");
} else {
    String response = connection.getResponseMessage();
    // response content contains json object with an attribute "objectId" 
    // which holds the unique user id. You can either use this value or 
    // deviceToken to send a notification.
}