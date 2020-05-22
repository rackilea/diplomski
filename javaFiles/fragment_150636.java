final String JSON_PATH = "old.json";
final String JSON_PATH1 = "new.json";

BufferedWriter bw = new BufferedWriter(new FileWriter(JSON_PATH1));
BufferedReader br = new BufferedReader(new FileReader(JSON_PATH));
JsonParser parser = new JsonParser();
JsonArray arrayObj = parser.parse(br).getAsJsonArray();


for (int i = 0; i < arrayObj.size(); i++) {

     JsonObject burObj = arrayObj.get(i).getAsJsonObject();

     burObj.getAsJsonObject().addProperty("info", NewTextGen(burObj.get("info").getAsString());
     burObj.getAsJsonObject().addProperty("sometext", NewTextGen(burObj.get("sometext").getAsString());

     Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
     FileWriter fr = new FileWriter(JSON_PATH1);
     BufferedWriter bw = new BufferedWriter(fr);
     gson.toJson(arrayObj, new JsonWriter(bw));
     bw.flush();


    }