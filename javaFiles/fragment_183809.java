String responseBody = "{\n" + 
               "  \"query\": \"what is the weather like in texas\",\n" + 
               "  \"topScoringIntent\": {\n" + 
               "    \"intent\": \"GetWeather\",\n" + 
               "    \"score\": 0.697563648\n" + 
               "  },\n" + 
               "  \"entities\": [\n" + 
               "    {\n" + 
               "      \"entity\": \"texas\",\n" + 
               "      \"type\": \"Location\",\n" + 
               "      \"startIndex\": 28,\n" + 
               "      \"endIndex\": 32,\n" + 
               "      \"score\": 0.693443358\n" + 
               "    }\n" + 
               "  ]\n" + 
               "}";
   Gson gson = new GsonBuilder().create();
   Result jsonsluisresult = gson.fromJson(responseBody, Result.class);   
   System.out.println("Intent :" + jsonsluisresult.getTopScoringIntent().getIntent());
   System.out.println("Entity :" + jsonsluisresult.getEntities().get(0).getEntity());