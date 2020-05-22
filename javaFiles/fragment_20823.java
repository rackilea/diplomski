try {
        JSONObject JsonObject=new JSONObject(jsondata);  
        JSONObject object=JsonObject.getJSONObject("request");  
        String action=object.getString("action");  
        String lng=object.getString("lng");  
        String lat=object.getString("lat");  
        String rangeKey=object.getString("rangeKey");  
        String schoolName=object.getString("schoolName");  

    } catch (JSONException e) {  
        // TODO Auto-generated catch block  
        e.printStackTrace();  
    }