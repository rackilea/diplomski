try {
        JSONArray jsonArray= new JSONArray(responsedata);
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            String id=object.getString("id");
            String identifier=object.getString("identifier");
            String header_val=object.getString("header_val");
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }