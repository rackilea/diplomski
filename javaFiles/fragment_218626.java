String inputValue = @QueryParam(YOUR_KEY); // OR whatever way you get it
        /*
         * This inputValue will actually contain your value :-
         * {"take":75,"skip":0,"page":1,
         * "pageSize":75,"filter":{"logic":"and","filters":
         * [{"field":"prodCode","operator":"eq","value":"Z20"}]}}
         */

        JSONObject inputJSON = new JSONObject(inputValue); 
        //Now getting values from input JSON
        int take = inputJSON.getInt("take");
        int skip = inputJSON.getInt("skip");
        int page = inputJSON.getInt("page");
        int pageSize = inputJSON.getInt("pageSize");
        JSONObject filter = inputJSON.getJSONObject("filter"); // filter is again a JSONObject 
        String logic = filter.getString("logic");
        System.out.println(take + " "+skip + " "+page + " "+pageSize + " "+logic);
        JSONArray filters = filter.getJSONArray("filters"); // filters is a JSONArray

        for(int i = 0; i< filters.length(); i++){  // iterating over JSONArray 
        JSONObject jo = (JSONObject)filters.get(i); 
        String field = jo.getString("field"); 
        String operator = jo.getString("operator"); 
        String value = jo.getString("value"); 
        System.out.println(field + " "+operator + " "+value ); 
}