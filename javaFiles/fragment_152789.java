URL url = new URL("Your URL");
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.connect();
int responseCode = connection.getResponseCode();

if (responseCode == HttpURLConnection.HTTP_OK) {
// if Website is ok this wil be called
}