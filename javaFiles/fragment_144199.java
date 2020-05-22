Object obj = parser.parse(new FileReader("src/bigbangtheory.json"));

JSONObject seasons = (JSONObject) obj;
System.out.println(seasons);

JSONArray seasonTwo = (JSONArray) seasons.get("2");
System.out.println(seasonTwo);

for (Object o : seasonTwo) {
    JSONObject episode = (JSONObject) o;
    Object title = episode.get("title");
    System.out.println(title);
}