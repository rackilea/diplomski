JsonArray jArray = new JsonArray();
while (result.next())
{
    String  type_json=result.getString("type");
    String name_json=result.getString("name");
    String id_json=result.getString("demo");
    JsonObject jObj = new JsonObject();
    jobj.put("id", id_json);
    jobj.put("type", type_json);
    jobj.put("name", name_json);
    jArray.put(jObj);
}

JsonObject jObjDevice = new JsonObject();
jObjDevice.put("device", jArray);
JsonObject jObjDeviceList = new JsonObject();
jObjDevice.put("devicelist", jObjDevice );