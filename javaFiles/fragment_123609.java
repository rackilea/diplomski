HttpClient httpclient = new DefaultHttpClient();
//... code skipped
String responseString = "";
try {
//... code skipped
} catch (IOException e) {
} finally {
     httpClient.getConnectionManager().shutdown();
}