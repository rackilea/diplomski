JSONParser parser = new JSONParser();
    Object parsedObject = parser.parse(jsonStr);

    JSONObject jsonObject = (JSONObject) parsedObject;
    JSONArray layers = (JSONArray) jsonObject.get("layers"); 

    JSONObject data = (JSONObject) layers.get(0);   
    JSONArray mapData = (JSONArray) data.get("data");   
    int[] mapTile = new int[mapData.size()];
    for (int i = 0; i < mapData.size(); i++) {
        mapTile[i] = ((Long)mapData.get(i)).intValue();
    }

    data = (JSONObject) layers.get(1);  
    JSONArray objectData = (JSONArray) data.get("data");    
    int[] objectTile = new int[objectData.size()];
    for (int i = 0; i < objectData.size(); i++) {
        objectTile[i] = ((Long)objectData.get(i)).intValue();
    }

    System.out.println(Arrays.toString(mapTile));
    System.out.println(Arrays.toString(objectTile));