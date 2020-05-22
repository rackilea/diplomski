String answer = "-32.430412,-58.321323,#-32.430412,-58.321323,#-32.430412,-58.321323,#";
// note that line breaks disappeared after parsing it to string
String[] parts = answer.split("#");

for (String point : parts) {
String[] pointData = point.split(",");
Float lat= Float.parseFloat(pointData[0]);
Float lng= Float.parseFloat(pointData[1]);
/// check if fit your actual map, remember you need everything required here loaded and declared before calling.
  mMap.addMarker(new MarkerOptions()
    .position(new LatLng(lat, lng))
    .title("Hello world"));


}