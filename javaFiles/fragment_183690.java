URL url = new URL("http://www.stackoverflow.com");
URLConnection urlConnection = url.openConnection();
InputStream result = urlConnection.getInputStream();

BufferedReader reader = new BufferedReader(new InputStreamReader(result));
String line = null;
while ((line = reader.readLine()) != null) {
    System.out.println(line);
}
reader.close();