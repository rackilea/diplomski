Try bellow.


JSONObject mainObj = new JSONObject(response); if(mainObj != null){
    String viewid = mainObj.getString("View_ID");  // here is your View_ID.
     JSONArray list = mainObj.getJSONArray("View");  // here is your view array.

    if(list != null){ for(int j = 0; j < list.length();j++){ JSONObject innerElem = list.getJSONObject(j); if(innerElem != null){ String button_id = innerElem.getString("Button_ID"); Toast.makeText(QRCode.this, button_id, Toast.LENGTH_SHORT).show(); } } } }