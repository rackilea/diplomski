for(int i=0;i<jsonArray.length();i++){
        JSONObject json = jsonArray.getJSONObject(i);
        // do this for all remaining field
        if(json.has("id")){
            String id = json.get("id").toString();
        }
        // finally put extra attributes to that jsonobject
        json.put("country", "USA");
        json.put("state", "KA")
    }