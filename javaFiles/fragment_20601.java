JSONObject jsonObj = new JSONObject(str);
JSONArray jsonArr = jsonObj.getJSONArray("items");

 for(int i =0 ; i<jsonArr.length() ;i++ ){
     JSONObject jsonObj1 = jsonArr.getJSONObject(i);

     System.out.println();
     System.out.println((i+1)+" ==========JSON OBJECT IS :========== ");

     Iterator<String> iter = jsonObj1.keys();
     while(iter.hasNext()){
         String key = iter.next();
         System.out.println(key + " : " + jsonObj1.get(key));


  }
 }