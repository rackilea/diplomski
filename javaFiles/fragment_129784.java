private String getJSONData(String field,JsonObject json){
    String data=null;
    if(json.has(field)){
        data=json.get(field).getAsString();
    }   
    return data;    
}