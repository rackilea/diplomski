String ss = "{\"gameWorlds\":[{\"worldName\":\"worldOne\",\"data\":[0,0,0,0,0,1,1,1,1,1,2,2,2,2,2],\"worldWidth\":5,\"worldHeight\":3,\"xSpawn\":5,\"ySpawn\":5}]}";
Object obj;
try {

    obj = parser.parse(ss);
    JSONObject base = (JSONObject) obj;
    JSONArray arrayGameWorld = (JSONArray) base.get("gameWorlds");
    for (int index = 0; index < arrayGameWorld.size(); index++) {
        JSONObject worldHeight = (JSONObject) arrayGameWorld.get(index);
        Long value = (Long) worldHeight.get("worldHeight");
        System.out.println(value);
        JSONArray dataArray = (JSONArray) worldHeight.get("data");
        System.out.println(obj);
    }
} catch (ParseException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}