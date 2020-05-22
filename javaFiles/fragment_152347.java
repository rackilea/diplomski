URL urlObj = new URL("http://access.alchemyapi.com/calls/url/URLGetRankedNamedEntities?apikey=" + API_KEY_HERE + "&url=http://www.smashingmagazine.com/2015/04/08/web-scraping-with-nodejs/&outputMode=json");
System.out.println(urlObj.toString() + "\n");

URLConnection connection = urlObj.openConnection();
connection.connect();

BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

String line;
StringBuilder builder = new StringBuilder();
while ((line = reader.readLine()) !=  null) {
    builder.append(line + "\n");
}

System.out.println(builder);