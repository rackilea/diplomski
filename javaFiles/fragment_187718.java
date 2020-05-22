JsonObject jObj = new JsonObject();

    JsonObject jObj1 = new JsonObject();
    JsonObject jObj2 = new JsonObject();

    JsonObject jObj21 = new JsonObject();
    JsonObject jObj22 = new JsonObject();

    jObj1.addProperty("jObj11", "value11");
    jObj1.addProperty("jObj12", "value12");


    jObj21.addProperty("jObj211", "value211"); // level 2
    jObj21.addProperty("jObj212", "value212");
    jObj21.addProperty("jObj213", "value213");

    jObj22.addProperty("jObj221", "value221");
    jObj22.addProperty("jObj222", "value222");
    jObj22.addProperty("jObj223", "value223");

    jObj2.add("jObj21", jObj21);  // level 1
    jObj2.add("jObj22", jObj22);

    jObj.add("jObj1", jObj1); // level 0
    jObj.add("jObj2", jObj2);

    String json = new Gson().toJson(jObj);