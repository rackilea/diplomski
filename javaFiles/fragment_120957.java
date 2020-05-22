if( inputJs.getJSONObject("Report").get("Information") instanceof JSONArray){

        JSONArray infoArray = inputJs.getJSONObject("Report").get("Information");

    for (int i = 0; i < infoArray.length(); i++) {
        JSONObject information = infoArray.getJSONObject(i);

        Iterator<String> keys = information.keys();

        while (keys.hasNext()) {
            String tableName = keys.next();
            JSONArray table = information.getJSONArray(tableName);

            for (int j = 0; j < table.length(); j++) {
                JSONObject data = table.getJSONObject(j);
                String k = data.keys().next();

                if (k.equals("GUID")) {
                    data.put("GUID", GetRegExpr(3));
                }
            }
        }
    }
    }