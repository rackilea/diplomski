JsonReader reader = new JsonReader(new FileReader("file.json"));
List<MapaNomes> mapaNomeses = new Gson().fromJson(
                                reader, 
                                new TypeToken<List<Review>>() {}.getType());

Then you can do whatever you want with each and every one of them

for (MapaNomes mapaNomes : mapaNomeses) {
    // whatever
}