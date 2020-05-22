JsonParser parser = new JsonParser();
JsonObject rootObj = parser.parse(json).getAsJsonObject();

//Here is the change
JsonObject locObj = rootObj
                      .getAsJsonObject("data")
                      .getAsJsonArray("children")
                      .get(0)
                      .getAsJsonObject()
                      .getAsJsonObject("data");

String subreddit = locObj.get("subreddit").getAsString();