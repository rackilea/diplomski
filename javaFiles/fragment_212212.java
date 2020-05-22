Gson gson = new Gson();
        String filename="/pathTo/json.json";
        JsonReader reader = new JsonReader(new FileReader(filename));
        JsonLevel jsonlevel= gson.fromJson(reader, JsonLevel.class);
        System.out.println("jsonlevel: " + gson.toJson(jsonlevel));

        Map<String, String> jl3 = jsonlevel.getJsonLevel1().getJsonLevel2().getJsonLevel3();
        /*for (Map.Entry<String, String> entry : jl3.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }*/
        JsonLevel3 jlev3=gson.fromJson(gson.toJson(jl3), JsonLevel3.class);
        System.out.println("jlev3: " + gson.toJson(jlev3));