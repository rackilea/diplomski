URL myURL = new URL(serviceURL);
HttpURLConnection myURLConnection = (HttpURLConnection)myURL.openConnection();

String userCredentials = "username:password";
String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));

myURLConnection.setRequestProperty ("Authorization", basicAuth);
myURLConnection.setRequestMethod("POST");
myURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
myURLConnection.setRequestProperty("Content-Length", "" + postData.getBytes().length);
myURLConnection.setRequestProperty("Content-Language", "en-US");
myURLConnection.setUseCaches(false);
myURLConnection.setDoInput(true);
myURLConnection.setDoOutput(true);