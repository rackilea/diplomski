JSONArray jarray = (JSONArray) parser.parse(new FileReader("wadepools.json"));

      for (Object o : jarray )
      {
        JSONObject value= (JSONObject) o;

        String type= (String) value.get("type");
        System.out.println(type);

       JSONArray features= (JSONArray) value.get("features");
  for (Object features: features)
        {
          System.out.println(features+"");
        }

      }