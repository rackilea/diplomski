jsonStr = "...";

Class<? extends HashMap> mapType = new HashMap<String, Object>().getClass();
Map data = new Gson().fromJson(job.jobContext, mapType);

JsonObject locations = data.get("Locations").getAsJsonObject();
JsonArray locationAry = locations.get("Location").getAsJsonArray();

for(JsonElement jsonEle: locationAry) {
   Location loc = new Location();
   JsonObject jsLoc = jsonEle.getAsJsonObject();
   loc.elevation = jsLoc.get("elevation").getAsInt();
   // ...
}