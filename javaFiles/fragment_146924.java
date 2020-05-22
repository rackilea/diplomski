public String selectYourData(int id, String param2, double param2){
    String res = "";
    try {

        // add parameters to list which need to match the parameters in your PHP code
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("param1", String.valueOf(id));
        params.put("param2", String.valueOf(id));
        params.put("param3", String.valueOf(id));

        // get the json string from the result set from the central database
        HttpRequestCommand http = new HttpRequestCommand();
        // the return is a json string containing the url of the             

        res = http.makeHttpRequestJsonString("my_php_script.php", params);
        JSONObject jObj = new JSONObject(res);
        String success = jObj.getString("success");
        if(success.contentEquals("1")){
            //Data downloaded successfully!!

        }
        else{ // else maybe do something??
            res = "MyWarningFlag"
        }
    }
    catch (Exception ex){
        Log.e(TAG, "selectData --- " + ex.getMessage());
    }
    return res;
}