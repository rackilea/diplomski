List<KaraokeCategoryModel> karaokeCategoryList = new ArrayList<KaraokeCategoryModel>();

JsonElement json = new JsonParser().parse(yourJsonStringValueHere);
JsonArray jsonArray = json.getAsJsonArray();
Iterator iterator = jsonArray.iterator();
while(iterator.hasNext()){
    JsonElement jsonElementInArray = (JsonElement)iterator.next();

    KaraokeCategoryModel karaokeCategory = new KaraokeCategoryModel();
    karaokeCategory.setName(jsonElementInArray.getAsString());

    karaokeCategoryList.add(karaokeCategory);    
}