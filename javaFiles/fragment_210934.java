JSONArray imageArray = new JSONArray();
imageArray.put("cmFodWxtaXNocmE=");
//* you can add more to the image array by using the put method

JSONObject company_one1 = new JSONObject();
company_one1.put("company_name", cmpy_name.getText()
         .toString().trim());
company_one1.put("company_address", cmpy_addrs.getText()
         .toString().trim());

//* add the image array
company_one1.put("image", imageArray);

//* create a JSONArray for company types,
JSONArray dataArray = new JSONArray();
dataArray.put(company_one1);
//* you can add more to the array here by using the put method

//* now put all in one main JSONObject
JSONObject mainObj = new JSONObect();
mainObj.put("id", "5");
mainObj.put("data", dataArray);

String finalJsonString = mainObj.toString();