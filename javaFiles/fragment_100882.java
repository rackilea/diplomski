HttpURLConnection fixerConnection = (HttpURLConnection) url.openConnection();
          fixerConnection.setRequestMethod("GET");
          BufferedReader jsonData = new BufferedReader(new 
          InputStreamReader(fixerConnection.getInputStream()));  
          JsonObject allData = new JsonParser().parse(jsonData).getAsJsonObject();
          // Now Take Rates as JSON Object and capture it in a Map.
          JsonObject rates =  allData.getAsJsonObject("rates");
          Set<Map.Entry<String, JsonElement>>  entries = rates.entrySet();