try {
        jsonArray1=new JSONArray(JsonResponse); // parse the Json response here
        obj1=new JSONObject();
        for (int i = 0; i < jsonArray1.length(); i++) {
            try {
                    JSONObject innerJson = jsonArray1.getJSONObject(i);
                    for(Iterator<String> iter = innerJson.keys();iter.hasNext();) 
                    {
                        String key = iter.next();
                        if(!key.equalIgnoreCase(myKey)) // myKey is the key you want to parse such as 1016
                            continue;
                        jsonArray2 = innerJson.getJSONArray(key);
                    }
                Log.v("test", "i"+i+ " obj1 "+jsonArray2);
            }
            catch (Exception e){
                Log.v("test", "exception "+e);
            }
        }

    } catch (JSONException e) {
        Log.v("MTV", "JsonParser exception" + e);
        e.printStackTrace();
    }