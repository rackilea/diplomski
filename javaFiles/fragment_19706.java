URL url = new URL("https://ajax.googleapis.com/ajax/services/feed/find?" +
              "v=1.0&q=Official%20Google%20Blog&userip=INSERT-USER-IP");
URLConnection connection = url.openConnection();
connection.addRequestProperty("Referer", /* Enter the URL of your site here */);

String line;
StringBuilder builder = new StringBuilder();
BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
while((line = reader.readLine()) != null) {
   builder.append(line);
}

JSONObject json = new JSONObject(builder.toString());
// now have some fun with the results...