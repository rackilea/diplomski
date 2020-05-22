BufferedReader fin = null; //create it
    Gson gson=new Gson();  //Google code open source library for JSON in Java  
    ArrayList<JSONObject> jsonList=new ArrayList<JSONObject>();    
    while (((line = fin.readLine()) != null)) {
                            if ( line.length()==0 ){
                                //"Blank line;
                            }else{
                                        currJSON=loadJSON(line);//You have to load it in a Java Object

                               if ( jsonList.size()<MAX_JSON){
                               jsonList.add(currJSON);
                            }

        if (JsonList.size()==MAX_JSON){ //Define the maximum size of the list you want to post
        gson.toJson(jsonList); //Convert to JSON
        //You should post your Json with some Http Connection to your server
    jsonList.clear();