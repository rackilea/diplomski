public JSONObject loginVehicle(String vehicleId, String password){
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("tag", login_tag));
    params.add(new BasicNameValuePair("vehicleId", vehicleId));
    params.add(new BasicNameValuePair("password", password));
    JSONObject json = jsonParser.getJSONFromUrl(loginVehicleURL, params);
    return json;
}