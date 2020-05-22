JSONArray array = new JSONArray(yourStringData);
for(int i = 0; i<array.length() ; i++){
   String productInfo = array.get(i);

   JSONObject object = new JSONObject(productInfo );
   String myRequiredData = object.get("products_id");
 }