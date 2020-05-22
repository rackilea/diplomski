JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET, urlJsonObj, null, new Response.Listener<JSONObject>() {
     @Override
     public void onResponse(JSONObject response) {
         for (String key : response.keySet()) {
             JSONObject entry = response.getJSONObject(key);
             Log.d(TAG, entry.toString());

             JSONObject phone = entry.getJSONObject("basic");
             String name = phone.getString("title");
             String email = phone.getString("description");
             JSONObject comments = entry.getJSONObject("comments");
             String home = comments.getString("count");
             JSONObject like = entry.getJSONObject("likes");
             String mobile = like.getString("count");

             jsonResponse = "";
             jsonResponse += "Name: " + name + "\n\n";
             jsonResponse += "Email: " + email + "\n\n";
             jsonResponse += "Home: " + home + "\n\n";
             jsonResponse += "Mobile: " + mobile + "\n\n\n";

             txtResponse.setText(txtResponse.getText() + "\n\n" + jsonResponse); //get the old text and add it to it
         }
     } 
}