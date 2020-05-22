public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

 try {

     JSONObject tempTransition = response.getJSONArray("items").getJSONObject(0).getJSONObject("snippet");

     Toast.makeText(getApplicationContext(), tempTransition.get("description").toString(), Toast.LENGTH_SHORT).show();

     if(!dirDirectoryJson.contains(tempTransition)){
           dirDirectoryJson.add(tempTransition);
     }

     getDescription = dirDirectoryJson.get(0).getString("description").toString().trim();
                setDescription( getDescription );
   } catch (JSONException e) {
      e.printStackTrace();
   }
}