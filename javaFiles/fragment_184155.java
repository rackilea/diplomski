jObject = new JSONObject(errorString); 

JSONArray menuitemArray = popupObject.getJSONArray("error_string");

String attributeValue = jObject.getString("value");

System.out.println(attributeValue);