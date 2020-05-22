JsonObject rootobj = root.getAsJsonObject();
JsonElement match_number = rootobj.get("match_number");
JsonObject alliances = rootobj.getAsJsonObject("alliances");
JsonElement blue = alliances.getAsJsonObject("blue").get("score");
JsonElement red  = alliances.getAsJsonObject("red").get("score");

System.out.println(match_number.getAsString()+","+blue.getAsString()+","+red.getAsString());