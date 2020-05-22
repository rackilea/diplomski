JSONObject json=new JSONObject(JSONResp);
    JSONArray arr=json.getJSONArray("publicaciones");
            for (int i = 0; i < arr.length(); i++) {

                result.add(convertItem(arr.getJSONObject(i)));

            }