try{
        JSONObject object = new JSONObject(json);
        JSONArray array = object.getJSONArray("features"); //get the features array
        JSONObject myObject= array.getJSONObject(5); //get the element 5
    }catch(Exception e){
        e.printStackTrace();
    }