JSONObject obj = new JSONObject("JsonString");
      Object temp = obj.get("MMTStaticCountrySearchResponse");
        List<String> list = new ArrayList<String>(); 
        JSONObject objtemp = new JSONObject(temp.toString());
        JSONArray array = objtemp.getJSONArray("Country");
        for(int i = 0 ; i < array.length() ; i++){
            list.add(array.getJSONObject(i).getString("HotelsCount"));
            System.out.println(array.getJSONObject(i).getString("CountryName"));
            System.out.println(array.getJSONObject(i).getString("HotelsCount"));
        }