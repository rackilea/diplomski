public String returnSearch(JSONArray array, String searchValue){
            JSONArray filtedArray = new JSONArray();
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj= null;
                try {
                    obj = array.getJSONObject(i);
                    if(obj.getString("name").equals(searchValue))
                    {
                        filtedArray.put(obj);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
        }
        String result = filtedArray.toString();
        return result;
   }