public void parseJson(String json){
        Gson gson = new Gson();
        Type stringStringMap = new TypeToken<Map<String, Map<String,String>>>(){}.getType();
        Map<String,Map<String,String>> map = gson.fromJson(json, stringStringMap);

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Map<String,String> innerMap = (Map<String,String>)pair.getValue();
            getInnerMapDetail(innerMap);
            it.remove(); // avoids a ConcurrentModificationException
        }
}
    public void getInnerMapDetail(Map<String,String> innerMap)
    {   
         String fileUploadDate = innerMap.get("fileUploadDate"); // you will get here
        }

    }