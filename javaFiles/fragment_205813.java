try{
    JSONArray json = new JSONArray(sb.toString());
    Courses coun;
    for(int i=0; i < json.length(); i++) {
        JSONObject jsonObject = json.getJSONObject(i);
        coun = new Courses();

        //          Log.i(TAG, "Nom Pays :  " + jsonObject.get("name"))
        coun.setName((String) jsonObject.get("name"));
        coun.setId((int) jsonObject.get("id"));
      //get des country
         JSONObject country = jsonObject.getJSONObject("country");
       //get code and other informations of country




      coun.setCountryCode(country.getString("code"));
        coun.setDescription((String) jsonObject.get("description"));
    /*    coun.setCourseTypeId((int) jsonObject.get("code"));
        coun.setDishesNumber((int) jsonObject.get("code")); */


        repas.add(coun);
    }
}catch (JSONException je){
    je.printStackTrace();
};