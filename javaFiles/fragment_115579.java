try {
     JSONArray arr = new JSONArray(result);
     for(int i=0;i<arr.length(); i++){
        JSONObject obj = arr.getJSONObject(i);
        ListMedicine bean = new ListMedicine();
        bean.setMedicine_name(obj.getString("medName"));
        .
        .
        .
       // at last add this into your list
       result.add(bean);
     }


}catch (Exception e) {
     // TODO Auto-generated catch block
    e.printStackTrace();
 }