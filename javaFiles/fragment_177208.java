JSONObject element = new JSONObject(result);

String metadata= element.getString("odata.metadata");

JSONArray valueArr = element.getJSONArray("value");

for (int i= 0; i< valueArr.length(); i++) {

    //get single object from array
    JSONObject item = valueArr.getJSONObject(i);

    String patient = item.getString("PatientID");
    String firstName= item.getString("FirstName");
    ...
}