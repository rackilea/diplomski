JSONArray pdoInformation = new JSONArray();

try{

// Added these lines in try block to send product details

  for(int i=0; i<productIds.size(); i++) {
     JSONObject obj = new JSONObject();
     obj.put("productid", productIds.get(i) );
     obj.put("qty", quantities.get(i));
     obj.put("listprice", listprices.get(i));
     pdoInformation.put(obj);
       }                
            objectJson.put("pdoInformation", pdoInformation);     
}