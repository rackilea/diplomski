public class EpisodesDetail {
    private int season;
    private Boolean[] episodes;
    // getter & setter 
}
...

BufferedReader reader = new BufferedReader(new FileReader(new File("json.txt")));
Type type = new TypeToken<Map<String, Object>>() {}.getType();
Map<String, Object> map = new Gson().fromJson(reader, type);

EpisodesDetail geometry = new EpisodesDetail();
geometry.setSeason(((Double) map.get("season")).intValue());
geometry.setEpisodes(((Map<String, Boolean>) map.get("episodes")).values().toArray(
        new Boolean[] {}));

System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(geometry));