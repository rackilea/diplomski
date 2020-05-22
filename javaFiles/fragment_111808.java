String jsonArray = {"myList":[{"code":"01","price":"2,3", "date":"21/12/2014"},{"code":"02","price":"3,4", "date":"26/12/2014"}]}

Gson gson = new Gson();
JsonParser parser = new JsonParser();

List<MyList> list = new ArrayList<MyList>();
try {
    JsonArray jArray = (JsonArray) parser.parse(jsonArray).getAsJsonObject().get("myList");

    for (JsonElement jObj : jArray) {
            MyList item = gson.fromJson( jObj , MyList.class);
            list.add(item);
    }

    } catch (Exception e) {
        e.printStackTrace();
    }