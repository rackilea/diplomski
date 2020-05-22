URL url = new URL("http://thegamesdb.net/api/GetGame.php?id=2");
HttpURLConnection http = (HttpURLConnection) url.openConnection(); 
http.addRequestProperty("User-Agent", "Mozilla/4.76"); 
InputStream is = http.getInputStream();
Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
customer = (Data) jaxbUnmarshaller.unmarshal(is);
List<Game> games = customer.getGames();
game = games.get(0);