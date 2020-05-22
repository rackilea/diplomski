JSONObject jObject = new JSONObject(jString);    
    String menuObject = jObject.getString("searchTerm");     
    JSONArray menuitemArray = jObject.getJSONArray("searchableLocations");   

    for (int i = 0; i < menuitemArray.length(); i++) {
        JSONObject jsonObj = menuitemArray.getJSONObject(i);     
        String attributeId = jsonObj.getString("identifier");     
        System.out.println(attributeId);     

        String attributeValue = jsonObj.getString("name");    
        System.out.println(attributeValue); 
    }

    String createDate = jObject.getString("jObject");
    String result = jObject.getString("result");