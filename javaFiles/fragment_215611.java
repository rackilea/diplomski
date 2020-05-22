// String json;

URL serverUrl = null;
try {
    serverUrl = new URL(Config.APP_SERVER_URL + URL);
} catch (MalformedURLException e) {
    ...
} 

try {
    byte[] bytes = json.getBytes("UTF-8");

    httpCon = (HttpURLConnection) serverUrl.openConnection();
    httpCon.setDoOutput(true);
    httpCon.setUseCaches(false);
    httpCon.setFixedLengthStreamingMode(bytes.length);
    httpCon.setRequestProperty("Authorization", tokenType + " "+ accessToken);
    httpCon.setRequestMethod("POST");
    httpCon.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

    OutputStream os = httpCon.getOutputStream();
    os.write(bytes);
    os.close();

    ...
}