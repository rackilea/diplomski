public static void main(String[] args) throws JSONException {
    String jsonString  = "{" + 
            "   \"MyResponse\": {" + 
            "       \"count\": 3," + 
            "       \"listTsm\": [{" + 
            "           \"id\": \"b90c6218-73c8-30bd-b532-5ccf435da766\"," + 
            "           \"simpleid\": 1," + 
            "           \"name\": \"vignesh1\"" + 
            "       }," + 
            "       {" + 
            "           \"id\": \"b90c6218-73c8-30bd-b532-5ccf435da766\"," + 
            "           \"simpleid\": 2," + 
            "           \"name\": \"vignesh2\"" + 
            "       }," + 
            "       {" + 
            "           \"id\": \"b90c6218-73c8-30bd-b532-5ccf435da766\"," + 
            "           \"simpleid\": 3," + 
            "           \"name\": \"vignesh3\"" + 
            "       }]" + 
            "   }" + 
            "}";


    JSONObject jsonObject = new JSONObject(jsonString);
    JSONObject myResponse = jsonObject.getJSONObject("MyResponse");
    JSONArray tsmresponse = (JSONArray) myResponse.get("listTsm");

    ArrayList<String> list = new ArrayList<String>();

    for(int i=0; i<tsmresponse.length(); i++){
        list.add(tsmresponse.getJSONObject(i).getString("name"));
    }

    System.out.println(list);
}   
}