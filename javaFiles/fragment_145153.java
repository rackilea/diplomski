JSONObject jsonObject = (JSONObject) obj;               
    JSONArray msg = (JSONArray) jsonObject.get("items");
    Iterator iterator = msg.iterator();
    while (iterator.hasNext()) {
      //System.out.println(iterator.next());
      JSONObject item = (JSONObject) iterator.next();
      JSONObject item_snippet = (JSONObject) item.get("snippet");
      System.out.println( item_snippet.get("title"));
    }