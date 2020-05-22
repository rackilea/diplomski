JSONArray userTypesArray = jsonResult.getJSONObject("xyx").getJSONObject("response").getJSONArray("hotels").getJSONObject(0).getJSONArray("userTypes");

    for(int i =0 ; i< userTypesArray.length(); i++){
        JSONObject userType = userTypesArray.getJSONObject(i);
        System.out.println(userType.get("title"));
    }