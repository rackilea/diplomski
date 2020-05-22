JSONArray jsonArray = new JSONArray();
    for (DBObject res : output.results()) {
        System.out.println(res);
        JSONObject jsonobj = new JSONObject();
        jsonobj.put("_id", res.get("_id"));
        jsonobj.put("totalcount", res.get("totalcount"));
        jsonArray.put(jsonobj);
    }
    System.out.println(jsonArray);