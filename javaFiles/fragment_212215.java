Gson gson = new Gson();
    String filename="/pathTo/json.json";
    JsonReader reader = new JsonReader(new FileReader(filename));
    JsonLevel jsonlevel= gson.fromJson(reader, JsonLevel.class);
    System.out.println("jsonlevel: " + gson.toJson(jsonlevel));

    Map<String, Object> jl3 = jsonlevel.getJsonLevel1().getJsonLevel2().getJsonLevel3();
    Map<String, Integer> jl4= (Map<String, Integer>) jl3.get("jsonLevel4");

    JsonLevel3 jlev3=gson.fromJson(gson.toJson(jl3), JsonLevel3.class);
    JsonLevel4 jlev4= gson.fromJson(gson.toJson(jl4), JsonLevel4.class);

    System.out.println("jlev3: " + gson.toJson(jlev3));
    System.out.println("jlev4: " + gson.toJson(jlev4));