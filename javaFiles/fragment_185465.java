void saveJsonThing(Object part, File file)
    if (part instanceof JSONObject){
      ((JSONObject)part).save(saveTo, "");
    }
    else if (part instanceof JSONArray){
      ((JSONArray)part).save(saveTo, "");
    }
    else{
       //handle error?
    }
}