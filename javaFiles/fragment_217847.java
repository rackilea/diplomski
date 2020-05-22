final String link = "bit.ly/18SuUzJ";
final URL url = new URL(link);
final HttpURLConnection urlConnection = 
(HttpURLConnection) url.openConnection();
urlConnection.setInstanceFollowRedirects(false);

final String location = 
urlConnection.getHeaderField("location");
System.out.println(location);