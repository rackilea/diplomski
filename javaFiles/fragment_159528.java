for (int i=0; i< response.length(); i++){
        Wall wall = new Wall();
        JSONObject jo = response.getJSONObject(i);
        wall.from_id = jo.getLong("from_id");
        wall.id = jo.getLong("id");
        wall.to_id = jo.getLong("to_id");
        wall.date = jo.getLong("date");
        wall.online = jo.getString("online");
        wall.text = jo.getString("text");
        result.add(wall);
    }