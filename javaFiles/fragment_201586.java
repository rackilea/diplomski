JSONArray rec=new JSONArray(result1);

JSONObject json=rec.getJSONObject(0);
JSONObject vehicle=json.getJSONObject("Vehicle");
JSONObject deviceLog=json.getJSONObject("DeviceLog");

String vehicleName=vehicle.getString("display_name");
int vehicleId=vehicle.getInt("id");

Double latitude=deviceLog.getDouble("latitude");
Double longitude=deviceLog.getDouble("longitude");

System.out.println(vehicleId +"  "+ vehicleName+ "  "+ latitude+"  "+longitude);