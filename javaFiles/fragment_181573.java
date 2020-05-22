URL form = new URL(Your_url);
connection1 = (HttpURLConnection)form.openConnection();
connection1.setRequestProperty("Cookie", your_cookie);

connection1.setReadTimeout(10000);
StringBuilder whole = new StringBuilder();

BufferedReader in = new BufferedReader(
        new InputStreamReader(new BufferedInputStream(connection1.getInputStream())));
String inputLine;
while ((inputLine = in.readLine()) != null)
     whole.append(inputLine);
     in.close();
Document doc = Jsoup.parse(whole.toString());
String title = doc.title();