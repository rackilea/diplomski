String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address;
String responseStr = fetch(url);
JsonHelper response =  JsonHelper.forString(responseStr);

String status = (String) response.getValue("status");
if(status != null && status.equals("OK")) {
   lat = (Double) response.getValue("results[0].geometry.location.lat");        
   lng = (Double) response.getValue("results[0].geometry.location.lng");
}