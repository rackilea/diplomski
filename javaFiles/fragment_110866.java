Weather aWeather = new Weather();
String lon = jsonHelperGetString(coord, "lon");
String lat = jsonHelperGetString(coord, "lat");
aWeather.lon = long;
aWeather.lat = lat;
...
return aWeather;